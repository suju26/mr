package at.fhjoanneum.ima.project.musclerebbot;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import at.fhjoanneum.ima.project.getfit.R;




public class Your_Profile_Fragment extends Activity {
	Spinner spinneractivity ;
	String selected_Activity_level;
	EditText age,height,weight;
	RadioGroup radiogender;
	RadioButton radioSexButton;
	Double bmr;
	View rootView ;
	SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;
	double tdde;
	String selectedgoal;
	String tdde_activity;
	TextView tdee_result;
	Spinner goal_spinner;

	Spinner nutri_spinner;
	String selectednutri;

	String Astatus;
	TextView text_gaol;
	TextView text_inch;

	double tdde_num;
	double tdde_goal;
	TextView txtview_percent_macro_protein;
	TextView txtview_percent_maccro_fats;
	TextView txtview_percent_maccro_carbs;
	TextView txt_macro_protein_percentage_manual;
	TextView txt_macro_fat_percentage_manual;
	TextView txt_macro_carb_percentage_manual;
	double your_pro,your_carbs,your_fats;
	TextView txt_macro_fats_percentage_manual;
	TextView txt_macro_carbs_percentage_manual;
	TextView your_goal;
	double macro_result;
	String savedplan;
	TextView bmi_text;
	double height_input;
	double weight_input;
	double bmi_result;
	double cm_to_meter;
	double age_input;
	int selectedId;
	String age_text_view,weight_string;
	double height_ft_to_cm,height_inch_cm;



	public Your_Profile_Fragment(){}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_your_profile);
		//Initializing all component
		age=(EditText)findViewById(R.id.profile_ui_age);
		radiogender=(RadioGroup)findViewById(R.id.radioGroup1);
		height=(EditText)findViewById(R.id.profile_ui_height_cm);
		text_inch=(EditText)findViewById(R.id.profile_ui_height_inch);
		weight=(EditText)findViewById(R.id.profile_ui_weight);
		sharedpreferences = this.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
		your_goal=(TextView)findViewById(R.id.macro_goal_calories_calculated);
		txtview_percent_macro_protein=(TextView)findViewById(R.id.macro_protein_percentage_calculated);
		txtview_percent_maccro_fats=(TextView)findViewById(R.id.macro_fat_percentage_calculated);
		txtview_percent_maccro_carbs=(TextView)findViewById(R.id.macro_carb_percentage_calculated);
		txt_macro_protein_percentage_manual=(TextView)findViewById(R.id.macro_protein_percentage_manual);
		txt_macro_fats_percentage_manual=(TextView)findViewById(R.id.macro_fat_percentage_manual);
		txt_macro_carbs_percentage_manual=(TextView)findViewById(R.id.macro_carb_percentage_manual);
		text_gaol=(TextView)findViewById(R.id.macro_goal_calories_calculated);
		txtview_percent_macro_protein=(TextView)findViewById(R.id.macro_protein_percentage_calculated);
		txtview_percent_maccro_fats=(TextView)findViewById(R.id.macro_fat_percentage_calculated);
		txtview_percent_maccro_carbs=(TextView)findViewById(R.id.macro_carb_percentage_calculated);
		txt_macro_protein_percentage_manual=(TextView)findViewById(R.id.macro_protein_percentage_manual);
		txt_macro_fats_percentage_manual=(TextView)findViewById(R.id.macro_fat_percentage_manual);
		txt_macro_carbs_percentage_manual=(TextView)findViewById(R.id.macro_carb_percentage_manual);
		bmi_text=(TextView)findViewById(R.id.textview_bmi);
	//	bmi_text.setText("Your Ideal Weight will display here base on your BMR and BMI calculation");
		
		//Setting content

		/*TextView first_content=(TextView)findViewById(R.id.textView20);
		first_content.setGravity(Gravity.CENTER_VERTICAL);
		first_content.setText(Html.fromHtml("<p>Everybody is different ,and even the most experienced coaches working with clients may get it wrong to start with.</p><p><em>Each person’s metabolism, overall health, and lifestyle all play a vital role in how much energy we actually burn and how much of each macronutrient we should be eating.</em></p><p>Basically it’s the amount of calories you burn in a day. Consistently eat less than this and you lose weight or eat more than this and you gain weight.</p><p>Fill in your Age , Height in 'cm' and Weight in 'Kg'.By calculating your body mass index(BMI), you can get an indication of whether your weight may be affecting your health.</p>"));
		TextView second_content=(TextView)findViewById(R.id.second);
		second_content.setText(Html.fromHtml("<p>Since most people don’t lie in bed all day doing absolutely nothing, we next have to figure out movement expenditure or TDEE</p><ul><li><strong>Sedentary<br></strong> Just normal everyday activity like a little walking, a couple flights of stairs, eating, talking etc.</li><p><li><strong>Light activity<br></strong>Any activity that burns an additional 200-400 calories for females or 250-500 calories for a males more than your sedentary amount.</p></li><p><li><strong>Moderate activity<br></strong>Any activity that burns an additional 400-650 calories for females or 500-800 calories for males more than your sedentary amount.</li></p><p><li><strong>Very Active<br></strong>Any activity that burns more than about 650 calories for females or more than 800 calories for males in addition to your sedentary amount.</li></p></ul><p></p>"));
		second_content.setGravity(Gravity.CENTER_VERTICAL);*/


		//For Selecting Activity Level
		Spinner activity_spinner = (Spinner)findViewById(R.id.spinnerprofile_ui_activity);
		List<String> setactivity = new ArrayList<String>();
		setactivity.add("Select Your Activity Level");
		setactivity.add("Sedentary");
		setactivity.add("Light Activity");
		setactivity.add("Moderate Activity");
		setactivity.add("Very Active");
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, setactivity);
		// Drop down layout style - list view with radio button
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		activity_spinner.setAdapter(dataAdapter);
		//Performing operation 
		spinneractivity = (Spinner)findViewById(R.id.spinnerprofile_ui_activity);
		spinneractivity.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selected_Activity_level=parent.getItemAtPosition(position).toString();	
				Log.d("", "selecteditem : "+selected_Activity_level);


				//BMR Calculation 
				selectedId=radiogender.getCheckedRadioButtonId();
				radioSexButton=(RadioButton)findViewById(selectedId);

				if(radioSexButton.getText().equals("Male")){
					bmr=10*weight_input+6.25*height_input-5*age_input+5;
				}
				if(radioSexButton.getText().equals("Female"))
				{
					bmr=10*weight_input+6.25*height_input-5*age_input-161;

				}



				if(selected_Activity_level.equals("Sedentary"))
				{
					tdde=bmr*1.2;
				}
				if(selected_Activity_level.equals("Light Activity"))
				{
					tdde=bmr*1.375;
				}
				if(selected_Activity_level.equals("Moderate Activity"))
				{
					tdde=bmr*1.55;
				}
				if(selected_Activity_level.equals("Very Active"))
				{
					tdde=bmr*1.725;
				}
				String final_tdde=Double.toString(Math.round(tdde));
				tdee_result=(TextView)findViewById(R.id.txt_result);
				tdee_result.setText(final_tdde);




			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}

		});

		//For Goal Selector
		Spinner goal_spinner = (Spinner)findViewById(R.id.macro_goal_spinner);
		List<String> setactivity1 = new ArrayList<String>();
		setactivity1.add("Choose your Goal");
		setactivity1.add("Gain Weight");
		setactivity1.add("Loss Weight");
		setactivity1.add("Maintain Weight");
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, setactivity1);
		// Drop down layout style - list view with radio button
		dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		goal_spinner.setAdapter(dataAdapter1);
		goal_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selectedgoal=parent.getItemAtPosition(position).toString();	


				//TDEE Calculation Based on Goal Selected


				if(selectedgoal.equals("Gain Weight"))
				{
					tdde_activity=tdee_result.getText().toString();
					Log.e("", "Sujit"+tdde_activity);
					tdde_num=Double.parseDouble(tdde_activity);
					tdde_goal=tdde_num+(tdde_num*0.20);
					text_gaol.setText(""+Math.round(tdde_goal));

				}

				if(selectedgoal.equals("Loss Weight"))
				{
					tdde_activity=tdee_result.getText().toString();
					tdde_num=Double.parseDouble(tdde_activity);
					tdde_goal=tdde_num-(tdde_num*0.20);
					text_gaol.setText(""+tdde_goal);

				}

				if(selectedgoal.equals("Maintain Weight"))
				{
					tdde_activity=tdee_result.getText().toString();
					tdde_num=Double.parseDouble(tdde_activity);
					tdde_goal=tdde_num;
					text_gaol.setText(""+tdde_goal);

				}
				Log.d("", "selecteditem : "+selectedgoal);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}

		});
		//For Nutrition Plan 
		nutri_spinner = (Spinner)findViewById(R.id.macro_nutrition_spinner);

		List<String> setnutri = new ArrayList<String>();
		setnutri.add("Choose Your Goal");
		setnutri.add("Ketogenic Macro");
		setnutri.add("Zone Macro");
		setnutri.add("Low Carb Macro");
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter11 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, setnutri);
		// Drop down layout style - list view with radio button
		dataAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		nutri_spinner.setAdapter(dataAdapter11);

		//nutri_spinner.setSelection(Integer.parseInt(savedplan));


		//Spinner Activity Level
		nutri_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {



			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				selectednutri=String.valueOf(position);//parent.getItemAtPosition(position).toString();
				Log.d("", "selecteditem : "+selectednutri);

				if(selectednutri.equals("0"))
				{				
					macro_result=Double.parseDouble(your_goal.getText().toString());
					txtview_percent_macro_protein.setText("0%");
					txtview_percent_maccro_fats.setText("0%");
					txtview_percent_maccro_carbs.setText("0%");
					your_pro=macro_result*0;
					your_carbs=macro_result*0;
					your_fats=macro_result*0;

					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));

				}

				if(selectednutri.equals("1"))
				{
					macro_result=Double.parseDouble(your_goal.getText().toString());
					txtview_percent_macro_protein.setText("35%");
					txtview_percent_maccro_fats.setText("60%");
					txtview_percent_maccro_carbs.setText("5%");
					your_pro=macro_result*0.35/4;
					your_carbs=macro_result*0.05/4;
					your_fats=macro_result*0.6/9;
					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));

				}
				if(selectednutri.equals("2"))
				{
					txtview_percent_macro_protein.setText("30%");
					txtview_percent_maccro_fats.setText("60%");
					txtview_percent_maccro_carbs.setText("40%");

					your_pro=macro_result*0.30/4;
					your_carbs=macro_result*0.40/4;
					your_fats=macro_result*0.60/9;
					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));
				}

				if(selectednutri.equals("3"))
				{
					txtview_percent_macro_protein.setText("45%");
					txtview_percent_maccro_fats.setText("30%");
					txtview_percent_maccro_carbs.setText("25%");	

					your_pro=macro_result*0.45/4;
					your_carbs=macro_result*0.25/4;
					your_fats=macro_result*0.30/9;
					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				txtview_percent_macro_protein.setText("0%");


			}

		});

		Button btw=(Button)findViewById(R.id.btn_bmi);
		btw.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bmi_calculation();
			}
		});
	}


	public void bmi_calculation() {
		String height_ft_textview=height.getText().toString();
		if(height_ft_textview.equals(""))
		{
			height_ft_textview="0";
		}
		String height_inch_textview=text_inch.getText().toString();
		if(height_inch_textview.equals(""))
		{
			height_inch_textview="0";
		}
		height_ft_to_cm=Double.parseDouble(height_ft_textview)/0.032808;
		height_inch_cm=Double.parseDouble(height_inch_textview)*2.54;
		//Handling null value 

		age_text_view=age.getText().toString();
		if(age_text_view.equals(""))
		{
			age_text_view="0";
		}


		weight_string=weight.getText().toString();
		if(weight_string.equals(""))
		{
			weight_string="0";
		}


		Toast.makeText(this, "Please enter all required field",
				Toast.LENGTH_SHORT).show();
		age_input= Double.parseDouble(age_text_view);

		height_input=height_ft_to_cm+height_inch_cm;

		weight_input= Double.parseDouble(weight_string);
		cm_to_meter= height_input/100*2;

		bmi_result=weight_input/cm_to_meter;




		if(bmi_result<18.5)
		{
			bmi_text.setText("You are underweight, so you may need to put on some weight. Your recommended Goal and Macro is Set.");
			bmi_text.setTextColor(Color.parseColor("#FF5722"));
		}
		if(bmi_result>=18.5 && bmi_result<=25)
		{
			bmi_text.setText("You are at a healthy weight for your height. Your recommended Goal and Macro is Sets.");
			bmi_text.setTextColor(Color.parseColor("#4CAF50"));
		}
		if(bmi_result>=25 && bmi_result<=30)
		{
			bmi_text.setText("You are slightly overweight. You may be advised to lose some weight for health reasons. Your recommended Goal and Macro is Set.");
			bmi_text.setTextColor(Color.parseColor("#FFA000"));
		}
		if(bmi_result>30)
		{
			bmi_text.setText("You are heavily overweight. Your health may be at risk if you do not lose weight. Your recommended Goal and Macro is Set.");
			bmi_text.setTextColor(Color.parseColor("#D32F2F"));
		}

	}






}






