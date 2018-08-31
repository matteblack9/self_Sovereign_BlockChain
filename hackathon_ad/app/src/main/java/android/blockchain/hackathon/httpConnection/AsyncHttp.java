package android.blockchain.hackathon.httpConnection;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by rlarh on 2018-01-25.
 */

public class AsyncHttp extends AsyncTask<Void, Void, String> {

    private String url = "http://uxoo.iptime.org:9000/";
    private Context context;
    private ContentValues values;

    public AsyncHttp() {
        super();
    }

    public AsyncHttp(Context context, String url, ContentValues values) {
        this.context = context;
        this.url += url;
        this.values = values;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected String doInBackground(Void... voids) {
        String result;
        WebConnection webConnection = new WebConnection();
        result = webConnection.request(context, url, values);
//
        return result;
    }
}
