package net.andruszko.lepapp.db;

import android.net.Uri;
import android.provider.BaseColumns;

public class LepProviderMetaData {
	
	public static final String AUTHORITY = "net.andruszko.provider.lepapp";
	public static final String DB_NAME = "lepapp.db";
        /**
         * Opis pytania
         */
	public static final String DB_TABLE_LEP_ITEM= "lepitem";
        /**
         * Słownik lepów
         */
	public static final String DB_TABLE_DICTLEPSESSION = "dictlepsession";
        /**
         * Poprawna odpowiedź
         */
        public static final String DB_TABLE_DICTCORRECTANS = "dictcorrectans";
        
        /**
         * język testu
         */
        public static final String DB_TABLE_DICTLANGUAGE = "dictlanguage";
        
        public static final String DB_TABLE_DICTLEPTYPE = "dictleptype";
        
        public static final String DB_TABLE_DICTSUBSECTION = "dictsubsection";
        
	public static final int DB_VERSION = 2;
	
	
	public static final class LepItemsTableMetaData implements BaseColumns {
		
		private LepItemsTableMetaData(){}
		
		public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/smsitems");
		
		public static final Uri CONTENT_URI_TO_SEND = Uri.parse("content://"+AUTHORITY+"/smsitemstosend");
		/**
		 * wysłane i z potwierdzeniem
		 */
		public static final Uri CONTENT_URI_SENT_SMS = Uri.parse("content://"+AUTHORITY+"/sentsms");
		/**
		 * wysłane ale bez potwierdzenia lub błędnie wyslane
		 */		
		public static final Uri CONTENT_URI_SENT_WITHOUT_ACK = Uri.parse("content://"+AUTHORITY+"/withoutack");
		
		public static final Uri CONTENT_URI_NEW_SMS = Uri.parse("content://"+AUTHORITY+"/newsms");
		
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.andruszko.sms";
		
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ibpolsoft.sms";
		
		public static final String KEY_ID = "id"; // unikalne id
		public static final String KEY_SESSION_ID = "session_id"; // id sesji 
                public static final String KEY_LEPTYPE_ID = "leptype_id"; // typ
                public static final String KEY_SECTION_ID = "section_id"; 
                public static final String KEY_LANG_ID = "lang_id"; // jezyk
		public static final String KEY_QUESTION = "question"; // pytanie
                public static final String KEY_POSITION = "position";
		public static final String KEY_ANSWER_A = "answer_a"; 
                public static final String KEY_ANSWER_B = "answer_b"; 
                public static final String KEY_ANSWER_C = "answer_c"; 
                public static final String KEY_ANSWER_D = "answer_d"; 
                public static final String KEY_ANSWER_E = "answer_e"; 
                
                // id poprawnej odpowiedzi
                public static final String KEY_CORRECT_ANSWER_ID = "correctans_id"; 
                
                
		
		
	}
        
        public static final class DictCorrectAns implements BaseColumns {
            public static final int  ANS_A = 10;
            public static final int  ANS_B = 20;
            public static final int  ANS_C = 30;
            public static final int  ANS_D = 40;
            public static final int  ANS_E = 50;
            
        }
	
	public static final class DictLepSessionTableMetaData implements BaseColumns  {
		
		/**
		 * 10|pobrany (ale nie wysłany)
		   20|wyslany
		   30|odebrany

		 */
		
		
		/**
		 * pobrany lecz nie wysłany
		 */
		public static final int SESSION_1 = 10;
		/**
		 * wysłany (bez potwierdzenia)
		 */
		public static final int SESSION_2 = 20;
		/**
		 *  wysłany i otrzymane potwiedzenie pozytywne
		 */
		public static final int SESSION_3 = 30;
		
		
	}

}