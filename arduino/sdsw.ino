#include <Adafruit_NeoPixel.h>
#include                                   <avr/power.h>
#define BRIGHTNESS     3
#define PIN            2
#define NUMPIXELS      64
#include <SPI.h>
#include <SD.h>

File myFile;

volatile int led = LOW, sw = LOW;
volatile unsigned long time_prev = 0, time_now;
unsigned long time_chat = 20;

int filenum=0;
int mode=0;
int frame=1;
int next=0;
int time=0;
int r_time=0;
int delayval = 100; // delay for half a second
Adafruit_NeoPixel pixels = Adafruit_NeoPixel(NUMPIXELS, PIN, NEO_GRB + NEO_KHZ800);
bool table[5][14] ={{0,1,1,1,1,1,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1},{0,1,1,1,1,1,0,0,1,1,1,1,1,0}};
unsigned char color[20][14]={{0}};

void setup() {
  attachInterrupt(1, blink, CHANGE);
  pixels.begin(); // This initializes the NeoPixel library.
  if (!SD.begin(4)) {
    
    return;
  }
  readNext();
}

void loop() {
  int count = 0;
  for(int i=0;i <5; i++){
    for(int j=0;j<14;j++){
      if(table[i][j]){
        unsigned char c;
        if(mode == 0) c=color[i+(time%frame)*5][j];
        else if(mode == 1)c = color[(i+time)%frame][j];
        else if(mode == 2)c = color[(i+frame-time)%frame][j];
        else if(mode == 3)c = color[(j+time)/14][(j+time)%14];
        else if(mode == 4)c = color[(j+frame-time)/14][(j+frame-time)%14];
        if(c==216)c=rainbow(r_time++);
        int r =getR(c);
        int g =getG(c);
        int b =getB(c);
        pixels.setPixelColor(count, pixels.Color(r,g,b)); // Moderately bright green color.
        count++;
      }  
    }
  }
  pixels.show();
  delay(delayval);
  time++;
  if(next!=0&&time == frame){
    readNext(next);
  }
}

char rainbow(int t){
  return toColor(rainbow(t,0),rainbow(t,1),rainbow(t,2));
}
int rainbow(int t,int c){
    int time = (t - c * 10+60)%30;
    if(0<=time&&time<=5)return time;
    else if (5<time&&time<=10) return 5;
    else if (10<time&&time<=15) return 5-(time-10);
    return 0;
}
int toColor(int r,int g,int b){
  return r+g*6+b*36;
}
int getR(unsigned c){
  return BRIGHTNESS*(c%6);
}
int getG(unsigned c){
  return BRIGHTNESS*((c/6)%6);
}
int getB(unsigned c){
  return BRIGHTNESS*(c/36);
}

void blink()
{
  time_now = millis(); //現在の割り込み時刻を取得
  if( time_now-time_prev > time_chat){
    if( sw == LOW ) //前回の割り込みから20[ms]以上経過かつスイッチの状態がLowならば、LED消点灯を切り替え
      {
        readNext();
      }
    sw = !sw; //前回の割り込みから20[ms]以上経過ならば、スイッチの状態を切り替え
  }
  time_prev = time_now; //現在の割り込み時刻を前回の割り込み時刻へコピー

}

void readNext(){
  int count=0;
  filenum++;
  myFile =SD.open(String(filenum));
  if(!myFile){
    filenum=1;
    myFile =SD.open(String(filenum));
  }
  mode = getNext();
  frame = getNext();
  next = getNext();
  delayval = getNext()*100;
  if(mode>=5)mode=mode-5;
  time=0;
  while (myFile.available()) {
      if(count/14>=20)break;
      color[count/14][count%14]=getNext();
      count++;
  }
  myFile.close();
}
void readNext(int num){
  int count=0;
  myFile =SD.open(String(num));
  mode = getNext();
  frame = getNext();
  next = getNext();
  delayval = getNext()*100;
  if(mode>=5)mode=mode-5;
  time=0;
  while (myFile.available()) {
      if(count/14>=20)break;
      color[count/14][count%14]=getNext();
      count++;
  }
  myFile.close();
}

int getNext(){
  String num="";
  while (myFile.available()) {
      char c = myFile.read();
      if(c==','){
        return num.toInt();
      }
      else{
        num=num+c;
      }
  }
  return 0;
}
