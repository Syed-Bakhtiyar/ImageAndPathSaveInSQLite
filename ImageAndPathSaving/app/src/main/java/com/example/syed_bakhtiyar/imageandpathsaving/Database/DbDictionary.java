package com.example.syed_bakhtiyar.imageandpathsaving.Database;

import android.provider.BaseColumns;

/**
 * Created by Syed_Bakhtiyar on 8/20/2017.
 */
public class DbDictionary {

    public static final String DATA_TABLE = "DataTable";

    public static final String IMAGE_TABLE = "ImageTable";

    public static final String PATH_TABLE = "DataTable";


    public class Data implements BaseColumns{

        public static final String _ID = "_id";

        public static final String MY_DATA = "my_data";

        public static final String FLOW = "flow";

    }


    public class Image_Saving implements BaseColumns{

        public static final String _ID = "_id";

        public static final String DATA_ID = "dataId";

        public static final String IMAGES = "images";

        public static final String IMAGE_NUMBER = "imagenumber";


    }

    public class path_Saving implements BaseColumns{

        public static final String _ID = "_id";

        public static final String DATA_ID = "dataId";

        public static final String PATH = "PATH";

        public static final String IMAGE_NUMBER = "imagenumber";

    }

}
