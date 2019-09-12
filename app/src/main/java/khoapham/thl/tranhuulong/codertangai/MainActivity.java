package khoapham.thl.tranhuulong.codertangai;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Dialog dialog;
    Button mbtnKhong;
    Button mbtnCo;
    final Timer timer = new Timer();
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnKhong = findViewById(R.id.buttonKhong);
        mbtnCo = findViewById(R.id.buttonCo);

        constraintLayout = findViewById(R.id.constrainLayout);

        final DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        final Random btnRandom = new Random();
        final int width = constraintLayout.getWidth();
        final int height = constraintLayout.getHeight();

        mbtnKhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DisplayMetrics displaymetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Random R = new Random();
                                final float dx = R.nextFloat() * displaymetrics.widthPixels;
                                final float dy = R.nextFloat() * displaymetrics.heightPixels;
                                final Timer timer = new Timer();
                                mbtnKhong.animate()
                                        .x(dx)
                                        .y(dy)
                                        .setDuration(0)
                                        .start();
                            }
                        });
                    }
                }, 0, 100);
            }
        });
        mbtnCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                showAlertDialog();
            }
        });
    }
    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mãi yêu. hihihi");
        builder.setMessage("Không thoát được đâu con trai.. tobe không tình yêu");
        builder.setCancelable(false);
        builder.setPositiveButton("Click here!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "hahahahahahahahahaaahahahaha", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
