package net.andruszko.lepapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.inject.Inject;
import net.andruszko.lepapp.utils.ActivityMetadata;
import net.andruszko.lepapp.utils.PreferenceNames;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import roboguice.util.Ln;

public class LepActivity extends RoboActivity {

    @InjectView(R.id.sessionsSpinner)
    private Spinner sessionSpinner;
    @InjectView(R.id.lepTypeSpinner)
    private Spinner lepTypeSpinner;
    @InjectView(R.id.langSpinner)
    private Spinner langSpinner;
    @InjectView(R.id.subSectionSpinner)
    private Spinner subSectionSpinner;
    @InjectView(R.id.startRandomActivity)
    private Button startRandomLepBtn;
    @Inject
    private SharedPreferences sharedPreferences;
    @Inject
    private Resources resources;
    @Inject
    private Context ctx;
    @InjectView(R.id.subSectionLabel)
    private TextView subSectionLabel;
 
    
    public static final String[] subSection = new String[]{"Wszystkie", "Interna", "Pediatria", "Chirurgia", "Ginekologia i Położnictow", "Med. rodzinna", "Psychiatria", "Med. Ratunkowa i Intensywna", "Prawo med. i bioetyka", "Orzecznictwo", "Zdrowie publiczne"};
    public static final String[] lang = new String[]{"PL", "EN"};
    public static final String[] lepType = new String[]{"LEP", "LDEP"};

    private void loadProferences() {
        
        Ln.v("brach test");
        int subSectionPosition = sharedPreferences.getInt(PreferenceNames.PREF_SUBSECIION_VALUE, 0);
        int sessionPosition = sharedPreferences.getInt(PreferenceNames.PREF_SESSION_VALUE, 0);
        int langPosition = sharedPreferences.getInt(PreferenceNames.PREF_LANG_VALUE, 0);
        int lepTypePosition = sharedPreferences.getInt(PreferenceNames.PREF_LEPTYPE_VALUE, 0);

        if (subSectionPosition < subSectionSpinner.getCount()) {
            subSectionSpinner.setSelection(subSectionPosition);
        } 

        if (sessionPosition < sessionSpinner.getCount()) {
            sessionSpinner.setSelection(sessionPosition);
        }

        if (langPosition < langSpinner.getCount()) {
            langSpinner.setSelection(langPosition);
        }
        if (lepTypePosition < lepTypeSpinner.getCount()) {
            lepTypeSpinner.setSelection(lepTypePosition);
        }


        Ln.v("subSectionPos " + subSectionPosition + " count " + subSectionSpinner.getCount());
    }

    private void savePreferences() {
        Editor editor = sharedPreferences.edit();
        editor.putInt(PreferenceNames.PREF_SUBSECIION_VALUE, subSectionSpinner.getSelectedItemPosition());
        editor.putInt(PreferenceNames.PREF_SESSION_VALUE, sessionSpinner.getSelectedItemPosition());
        editor.putInt(PreferenceNames.PREF_LANG_VALUE, langSpinner.getSelectedItemPosition());
        editor.putInt(PreferenceNames.PREF_LEPTYPE_VALUE, lepTypeSpinner.getSelectedItemPosition());
        editor.commit();
    }
    
    private void showLepSubSections(){
        subSectionSpinner.setVisibility(View.VISIBLE);
        subSectionLabel.setVisibility(View.VISIBLE);
    }
    
    private void hideLepSubSections(){
        subSectionSpinner.setVisibility(View.GONE);
        subSectionLabel.setVisibility(View.GONE);
    }

   /**
     * Przerzucic stałe tekstowe do strings.xml
     * @param savedInstanceState 
     */     

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        PackageManager pm = getPackageManager();
        
        ArrayAdapter<CharSequence> sessionAdapter = ArrayAdapter.createFromResource(this, R.array.session_items, android.R.layout.simple_spinner_item);
        sessionSpinner.setAdapter(sessionAdapter);
        sessionSpinner.setPrompt("Sessja");

        ArrayAdapter<String> langAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lang);
        langSpinner.setAdapter(langAdapter);
        langSpinner.setPrompt("Język");

        ArrayAdapter<String> lepTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lepType);
        lepTypeSpinner.setAdapter(lepTypeAdapter);
        lepTypeSpinner.setPrompt("Typ egzaminu");
        lepTypeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
                if (lepType[position].equals("LEP")){
                    showLepSubSections();
                }else{
                    hideLepSubSections();
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<String> subSectionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subSection);
        subSectionSpinner.setAdapter(subSectionAdapter);
        subSectionSpinner.setPrompt("Poddział");
        subSectionSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        loadProferences();

        startRandomLepBtn.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                Intent startIntent = new Intent(ActivityMetadata.RANDOMLEPITEM_ACTIVITY_URL);
                startIntent.putExtras(createBundle());                
                startActivity(startIntent);
                savePreferences();
            }
        });               
    }
    
    private Bundle createBundle(){
        Bundle bundle = new Bundle();
        bundle.putString(BundleConstants.SESSION_ID,""+subSectionSpinner.getSelectedItemPosition());
        return bundle;
    }

}
