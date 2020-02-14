package paladeans.jsonsemgson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import paladeans.jsonsemgson.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private ListView listViewUsuarios;
    private Button buttonConsumir;
    private Button buttorGerar;
    private List<HashMap<String, String>> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConsumir = findViewById(R.id.buttonConsumir);
        buttorGerar = findViewById(R.id.buttonGerar);
        listViewUsuarios = findViewById(R.id.listViewUsuarios);
        listaUsuarios = new ArrayList<>();

        buttonConsumir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilJson uj = new UtilJson();
                uj.execute();
            }
        });

    }//onCreate

    private class UtilJson extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            String jsonString = getListData();

            if (jsonString != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray jsonArray = jsonObject.getJSONArray("users");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Usuario u = new Usuario();
                        JSONObject o = jsonArray.getJSONObject(i);
                        u.setNome(o.getString("name"));
                        u.setTitulo(o.getString("designation"));
                        u.setLocacao(o.getString("location"));


                        HashMap<String, String> users = new HashMap<>();
                        users.put("nome", u.getNome());
                        users.put("titulo", u.getTitulo());
                        users.put("locacao", u.getLocacao());

                        listaUsuarios.add(users);
                    }//for
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }//if
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this,
                    listaUsuarios,
                    R.layout.item_list,
                    new String[]{"nome", "titulo", "locacao"},
                    new int[]{R.id.textViewNome, R.id.textViewTitulo, R.id.textViewLocacao});
            listViewUsuarios.setAdapter(adapter);
        }

        private String getListData() {
            String jsonStr = "{ \"users\" :[" +
                    "{\"name\":\"Suresh Dasari\",\"designation\":\"Team Leader\",\"location\":\"Hyderabad\"}" +
                    ",{\"name\":\"Rohini Alavala\",\"designation\":\"Agricultural Officer\",\"location\":\"Guntur\"}" +
                    ",{\"name\":\"Trishika Dasari\",\"designation\":\"Charted Accountant\",\"location\":\"Guntur\"}] }";
            return jsonStr;
        }
    }//innerClass

}//class
