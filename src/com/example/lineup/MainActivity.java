package com.example.lineup;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.app.AlertDialog;
import java.util.Calendar;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MainActivity extends Activity implements android.view.View.OnClickListener {
	int NONE;
	int BLACK;
	int WHITE;
	int turn;
	int counter;
    Calendar calendar;
	Button[] buttons = new Button[64];
	int[] state = new int[64];
    int [] kifu = new int[64]; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        NONE = 0;
        BLACK = 1;
        WHITE = 2;
    	initialization();
        for(int i=0;i<64;i++){
        	buttons[i].setOnClickListener(this);
        	state[i]=NONE;
        }

    }
    @Override
    public void onClick(View v){
    	Button button=(Button)v;
    	int num=-1;
    	for(int i=0;i<64;i++){
    		if(buttons[i]==button){
    			num=i;
    		}
    	}
 	
    	if(placeable(num)){
    		if(turn==BLACK){
    			button.setText(getString(R.string.black_text));
            	button.setBackgroundColor(getResources().getColor(R.color.black_color));
    			state[num]=BLACK;
    			kifu[counter]=num;
    			counter++;
    			if(quad(num)){
    		        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
    		        alert.setTitle("result");
    		        alert.setMessage("orange win.");
    			    alert.create().show();
    			    writelog();
    			}
    			turn=WHITE;
    		}else if(turn==WHITE){
    			button.setText(getString(R.string.white_text));
    			button.setBackgroundColor(getResources().getColor(R.color.white_color));
    			state[num]=WHITE;
    			kifu[counter]=num;
    			counter++;
    			if(quad(num)){
    		        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
    		        alert.setTitle("result");
    		        alert.setMessage("blue win.");
    			    alert.create().show();
    			    writelog();
    			}
    			turn=BLACK;
    		}
    		if(counter>=64){
		        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
		        alert.setTitle("result");
		        alert.setMessage("draw.");
			    alert.create().show();
			    writelog();
			    
    		}
    	}
    }
    public void writelog(){
    	calendar = Calendar.getInstance();
        String year  = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String hour  = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String min   = String.valueOf(calendar.get(Calendar.MINUTE));
        String sec   = String.valueOf(calendar.get(Calendar.SECOND));
        String str ="";
        try {
            OutputStream out = openFileOutput(year+month+hour+min+sec+".txt",MODE_PRIVATE);
            for(int i=0;i<64;i++){
            	if(kifu[i]==-1){
            		break;
            	}else{
            	str=str+String.valueOf(kifu[i])+" ";
            	}
            }
        	Log.d("Debug",str);
        	PrintWriter writer=new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
        	writer.write(str);
        	writer.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
    
    public void initialization(){
        turn = WHITE;
        counter=0;
        calendar = Calendar.getInstance();
        
        buttons[0] = (Button) this.findViewById(R.id.btn111);
        buttons[1] = (Button) this.findViewById(R.id.btn211);
        buttons[2] = (Button) this.findViewById(R.id.btn311);
        buttons[3] = (Button) this.findViewById(R.id.btn411);
        buttons[4] = (Button) this.findViewById(R.id.btn121);
        buttons[5] = (Button) this.findViewById(R.id.btn221);
        buttons[6] = (Button) this.findViewById(R.id.btn321);
        buttons[7] = (Button) this.findViewById(R.id.btn421);
        buttons[8] = (Button) this.findViewById(R.id.btn131);
        buttons[9] = (Button) this.findViewById(R.id.btn231);
        buttons[10] = (Button) this.findViewById(R.id.btn331);
        buttons[11] = (Button) this.findViewById(R.id.btn431);
        buttons[12] = (Button) this.findViewById(R.id.btn141);
        buttons[13] = (Button) this.findViewById(R.id.btn241);
        buttons[14] = (Button) this.findViewById(R.id.btn341);
        buttons[15] = (Button) this.findViewById(R.id.btn441);
        
        buttons[16] = (Button) this.findViewById(R.id.btn112);
        buttons[17] = (Button) this.findViewById(R.id.btn212);
        buttons[18] = (Button) this.findViewById(R.id.btn312);
        buttons[19] = (Button) this.findViewById(R.id.btn412);
        buttons[20] = (Button) this.findViewById(R.id.btn122);
        buttons[21] = (Button) this.findViewById(R.id.btn222);
        buttons[22] = (Button) this.findViewById(R.id.btn322);
        buttons[23] = (Button) this.findViewById(R.id.btn422);
        buttons[24] = (Button) this.findViewById(R.id.btn132);
        buttons[25] = (Button) this.findViewById(R.id.btn232);
        buttons[26] = (Button) this.findViewById(R.id.btn332);
        buttons[27] = (Button) this.findViewById(R.id.btn432);
        buttons[28] = (Button) this.findViewById(R.id.btn142);
        buttons[29] = (Button) this.findViewById(R.id.btn242);
        buttons[30] = (Button) this.findViewById(R.id.btn342);
        buttons[31] = (Button) this.findViewById(R.id.btn442);
        
        buttons[32] = (Button) this.findViewById(R.id.btn113);
        buttons[33] = (Button) this.findViewById(R.id.btn213);
        buttons[34] = (Button) this.findViewById(R.id.btn313);
        buttons[35] = (Button) this.findViewById(R.id.btn413);
        buttons[36] = (Button) this.findViewById(R.id.btn123);
        buttons[37] = (Button) this.findViewById(R.id.btn223);
        buttons[38] = (Button) this.findViewById(R.id.btn323);
        buttons[39] = (Button) this.findViewById(R.id.btn423);
        buttons[40] = (Button) this.findViewById(R.id.btn133);
        buttons[41] = (Button) this.findViewById(R.id.btn233);
        buttons[42] = (Button) this.findViewById(R.id.btn333);
        buttons[43] = (Button) this.findViewById(R.id.btn433);
        buttons[44] = (Button) this.findViewById(R.id.btn143);
        buttons[45] = (Button) this.findViewById(R.id.btn243);
        buttons[46] = (Button) this.findViewById(R.id.btn343);
        buttons[47] = (Button) this.findViewById(R.id.btn443);
        
        buttons[48] = (Button) this.findViewById(R.id.btn114);
        buttons[49] = (Button) this.findViewById(R.id.btn214);
        buttons[50] = (Button) this.findViewById(R.id.btn314);
        buttons[51] = (Button) this.findViewById(R.id.btn414);
        buttons[52] = (Button) this.findViewById(R.id.btn124);
        buttons[53] = (Button) this.findViewById(R.id.btn224);
        buttons[54] = (Button) this.findViewById(R.id.btn324);
        buttons[55] = (Button) this.findViewById(R.id.btn424);
        buttons[56] = (Button) this.findViewById(R.id.btn134);
        buttons[57] = (Button) this.findViewById(R.id.btn234);
        buttons[58] = (Button) this.findViewById(R.id.btn334);
        buttons[59] = (Button) this.findViewById(R.id.btn434);
        buttons[60] = (Button) this.findViewById(R.id.btn144);
        buttons[61] = (Button) this.findViewById(R.id.btn244);
        buttons[62] = (Button) this.findViewById(R.id.btn344);
        buttons[63] = (Button) this.findViewById(R.id.btn444);
        for(int i=0;i<64;i++){
//        	buttons[i].setText(R.string.none_text);
        	buttons[i].setBackgroundColor(getResources().getColor(R.color.none_color));
        	buttons[i].setOnClickListener(this);
        	state[i]=NONE;
        	kifu[i]=-1;
        }
    	
    }
    public Boolean placeable(int num){
    	int z=num/16;
    	int y=(num%16)/4;
    	int x=(num%16)%4;
    	if(state[num]==NONE){
    		if(z<=0){
    			return true;
    		}else{
    			return (state[(z-1)*16+y*4+x]==NONE)?false:true;
    		}
    	}else{
    		return false;
    	}
    }
    public Boolean quad(int last){
    	int z=last/16;
    	int y=(last%16)/4;
    	int x=(last%16)%4;
    	//fix yz axis
    	if(state[z*16+y*4]==state[z*16+y*4+1]&&state[z*16+y*4+1]==state[z*16+y*4+2]&&
    			state[z*16+y*4+2]==state[z*16+y*4+3]){
    		return true;
    	}
    	//fix zx axis
    	if(state[z*16+0*4+x]==state[z*16+1*4+x]&&state[z*16+1*4+x]==state[z*16+2*4+x]&&
    			state[z*16+2*4+x]==state[z*16+3*4+x]){
    		return true;
    	}
    	//fix xy axis
    	if(state[0*16+y*4+x]==state[1*16+y*4+x]&&state[1*16+y*4+x]==state[2*16+y*4+x]&&
    			state[2*16+y*4+x]==state[3*16+y*4+x]){
    		return true;
    	}
    	//fix z axis
    	if(x==y){
    		if(state[z*16+0*4+0]==state[z*16+1*4+1]&&state[z*16+1*4+1]==state[z*16+2*4+2]&&
    			state[z*16+2*4+2]==state[z*16+3*4+3]){
    			return true;
    		}
    	}
    	if(x==-y+3){
    		if(state[z*16+0*4+3]==state[z*16+1*4+2]&&state[z*16+1*4+2]==state[z*16+2*4+1]&&
    			state[z*16+2*4+1]==state[z*16+3*4+0]){
    			return true;
    		}
    	}
    	//fix x axis
    	if(y==z){
    		if(state[0*16+0*4+x]==state[1*16+1*4+x]&&state[1*16+1*4+x]==state[2*16+2*4+x]&&
    			state[2*16+2*4+x]==state[3*16+3*4+x]){
    			return true;
    		}
    	}
    	if(y==-z+3){
    		if(state[0*16+3*4+x]==state[1*16+2*4+x]&&state[1*16+2*4+x]==state[2*16+1*4+x]&&
    			state[2*16+1*4+x]==state[3*16+0*4+x]){
    			return true;
    		}
    	}
    	//fix y axis
    	if(z==x){
    		if(state[0*16+y*4+0]==state[1*16+y*4+1]&&state[1*16+y*4+1]==state[2*16+y*4+2]&&
    			state[2*16+y*4+2]==state[3*16+y*4+3]){
    			return true;
    		}
    	}
    	if(z==-x+3){
    		if(state[0*16+y*4+3]==state[1*16+y*4+2]&&state[1*16+y*4+2]==state[2*16+y*4+1]&&
    			state[2*16+y*4+1]==state[3*16+y*4+0]){
    			return true;
    		}
    	}
    	//x=y=z
    	if(x-y==0&&y-z==0){
    		if(state[0*16+0*4+0]==state[1*16+1*4+1]&&state[1*16+1*4+1]==state[2*16+2*4+2]&&
    			state[2*16+2*4+2]==state[3*16+3*4+3]){
    			return true;
    		}
    	}
    	if(x+y==3&&z+x==3){
    		if(state[0*16+0*4+3]==state[1*16+1*4+2]&&state[1*16+1*4+2]==state[2*16+2*4+1]&&
    			state[2*16+2*4+1]==state[3*16+3*4+0]){
    			return true;
    		}
    	}
        if(x+y==3&&y+z==3){
    		if(state[3*16+0*4+3]==state[2*16+1*4+2]&&state[2*16+1*4+2]==state[1*16+2*4+1]&&
    			state[1*16+2*4+1]==state[0*16+3*4+0]){
    			return true;
    		}
    	}

    	if(x+y==3&&y+z==3){
    		if(state[0*16+3*4+3]==state[1*16+2*4+2]&&state[1*16+2*4+2]==state[2*16+1*4+1]&&
    			state[2*16+1*4+1]==state[3*16+0*4+0]){
    			return true;
    		}
    	}
    	return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
