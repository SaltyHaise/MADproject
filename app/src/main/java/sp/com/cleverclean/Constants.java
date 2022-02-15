package sp.com.cleverclean;

public class Constants {
    public static final String DB_NAME = "BIN_INFO_DB";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "BIN_INFO_TABLE";

    public static final String C_ID = "ID";
    public static final String C_NAME = "NAME";
    public static final String C_ADDRESS="ADDRESS";
    public static final String C_DATE = "DATE";
    public static final String C_LAT = "LAT";
    public static final String C_LON = "LON";
    public static final String C_IMAGE = "IMAGE";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_NAME + " TEXT,"
            + C_ADDRESS + " TEXT,"
            + C_DATE + " TEXT,"
            + C_LAT + " REAL,"
            + C_LON + " REAL,"
            + C_IMAGE + " BLOB,"
            + ");";
}