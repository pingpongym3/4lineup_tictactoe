package com.example.lineup;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends Activity implements android.view.View.OnClickListener {
	int NONE;
	int BLACK;
	int WHITE;
	int turn;
	Button[] buttons = new Button[64];
	int[] state = new int[64];
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        NONE = 0;
        BLACK = 1;
        WHITE = 2;
        turn = WHITE;

        
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
        for(int i=0;i<16;i++){
        	buttons[i].setOnClickListener(this);
        	state[i]=NONE;
        }
    }
    @Override
    public void onClick(View v){
    	Button button=(Button)v;
    	int num=-1;
    	for(int i=0;i<16;i++){
    		if(buttons[i]==button){
    			num=i;
    		}
    	}
    	
    	String str=button.getText().toString();
    	if(str==getString(R.string.none_text)){
    		if(turn==BLACK){
    			button.setText(getString(R.string.black_text));
    			turn=WHITE;
    		}else if(turn==WHITE){
    			button.setText(getString(R.string.white_text));
    			turn=BLACK;
    		}
    	}
    	Log.d("Debug",""+num);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
