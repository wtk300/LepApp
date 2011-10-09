/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.andruszko.lepapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;

import net.andruszko.lepapp.db.LepProviderMetaData.DictCorrectAns;
import net.andruszko.lepapp.service.RandomLepItemService;
import net.andruszko.lepapp.vo.LepItemVO;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 *
 * @author wtk300
 */
public class RandomLepItemActivity extends RoboActivity {

    @InjectView(R.id.answer_a)
    private RadioButton rbAnswerA;
    @InjectView(R.id.answer_b)
    private RadioButton rbAnswerB;
    @InjectView(R.id.answer_c)
    private RadioButton rbAnswerC;
    @InjectView(R.id.answer_d)
    private RadioButton rbAnswerD;
    @InjectView(R.id.answer_e)
    private RadioButton rbAnswerE;
    @InjectView(R.id.question)
    private TextView question;
    @InjectView(R.id.randomTopLabel)
    private TextView topLabel;
    @InjectView(R.id.checkBtn)
    private Button checkButton;
    // @InjectView(R.id.sessionsSpinner)Spinner sessionSpinner;
    @Inject
    private Context ctx;
    @InjectView(R.id.randomRG)
    private RadioGroup randomRG;
    private LepItemVO lepItem;
    @Inject
    private RandomLepItemService randomItemService;
    private static final Map<Integer, Integer> ansMap = new HashMap<Integer, Integer>();

    static {
        ansMap.put(R.id.answer_a, DictCorrectAns.ANS_A);
        ansMap.put(R.id.answer_b, DictCorrectAns.ANS_B);
        ansMap.put(R.id.answer_c, DictCorrectAns.ANS_C);
        ansMap.put(R.id.answer_d, DictCorrectAns.ANS_D);
        ansMap.put(R.id.answer_e, DictCorrectAns.ANS_E);

    }

    private void setRandomLepItem(LepItemVO item) {

        lepItem = item;
        question.setText(item.getQuestion());
        topLabel.setText(item.getPosition() + ". Interna");
        rbAnswerA.setText(item.getAnswerA());
        rbAnswerB.setText(item.getAnswerB());
        rbAnswerC.setText(item.getAnswerC());
        rbAnswerD.setText(item.getAnswerD());
        rbAnswerE.setText(item.getAnswerE());
    }

    private int getColor(int i) {
        return getResources().getColor(i);
    }

    private void clearRB() {
        for (int rbId : ansMap.keySet()) {
            RadioButton rb = (RadioButton) findViewById(rbId);
            rb.setTextColor(getColor(R.color.Black));
        }
    }
    
    private void showInfo(String info){
        Toast toast = Toast.makeText(ctx, info, Toast.LENGTH_SHORT);
        toast.show();
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.leprandom);

        //ArrayAdapter<CharSequence> sessionsAdapter = ArrayAdapter.createFromResource(this, R.array.session_items,android.R.layout.simple_spinner_item);
        //sessionSpinner.setAdapter(sessionsAdapter);       
        setRandomLepItem(randomItemService.getRandomItem());

        Intent preferenceIntent = getIntent();

        if (preferenceIntent != null) {
             showInfo(preferenceIntent.getStringExtra("sessionId"));
        }

        //question.setTextSize(Float.parseFloat(getSharedPreferences(PreferenceNames.PREF_QUESTION_FONT_SIZE, Activity.MODE_PRIVATE)));

        question.setTextSize(17f);
        checkButton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                RadioButton choosenRB = (RadioButton) findViewById(randomRG.getCheckedRadioButtonId());

                if (choosenRB != null) {
                    //choosenRB.setBackgroundColor(getColor(R.color.Yellow));
                    clearRB();

                    int choosenAns = ansMap.get(choosenRB.getId());

                    /**
                     * user odp. poprawnie
                     */
                    if (choosenAns == lepItem.getCorrectAns()) {
                        choosenRB.setTextColor(getColor(R.color.lepGreen));
                        showInfo( "Poprawna odpowiedź");                        

                    } else { // user jest jelopem i zle odpowiedzial
                        choosenRB.setTextColor(getColor(R.color.Red));

                        for (int key : ansMap.keySet()) {

                            if (ansMap.get(key).equals(lepItem.getCorrectAns())) {
                                RadioButton shouldBeAns = (RadioButton) findViewById(key);
                                shouldBeAns.setTextColor(getColor(R.color.lepGreen));
                            }

                        }
                    }

                } else {
                    showInfo("Nie wybrano żadnej odpowiedzi");
                }

            }
        });

    }
}
