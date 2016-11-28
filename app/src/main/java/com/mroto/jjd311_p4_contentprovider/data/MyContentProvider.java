package com.mroto.jjd311_p4_contentprovider.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

//NEW->Other->ContentProvider, NO EXPORT,ENABLED, URI="com.mroto.myprovider"
public class MyContentProvider extends ContentProvider {
    private static final String TAG=MyContentProvider.class.getSimpleName();
    private static final String PROVIDER_AUTHORITY="com.mroto.jjd311_p4_contentprovider.data";
    public static final Uri CONTENT_URI =Uri.parse("content://" + MyContentProvider.PROVIDER_AUTHORITY);

    MyDatabaseHelper dbHelper;

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        long regId = db.insert(ParamsDb.TABLE_NAME,null,values);
        Uri retUri=ContentUris.withAppendedId(MyContentProvider.CONTENT_URI, regId);
        return retUri;
        /*Alternativa: db.execSQL("INSERT INTO...*/
    }

    @Override
    public boolean onCreate() {
        this.dbHelper= new MyDatabaseHelper(this.getContext());
        //Aqui no hace falta: dbHelper.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();
        Cursor queryCursor = db.query(ParamsDb.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);

        return queryCursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
