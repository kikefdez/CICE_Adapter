package com.quique.cice_adapter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] listaArticulos = {
            "Artículo 1", "Articulo 2", "Articulo 3", "Articulo 4", "Articulo 5", "Articulo 6", "Articulo 7", "Articulo 8", "Articulo 9", "Articulo 10",
            "Articulo 11", "Articulo 12", "Articulo 13", "Articulo 14", "Articulo 15", "Articulo 16", "Articulo 17", "Articulo 18", "Articulo 19", "Articulo 20"
    };
    private static Boolean[] listaEstado = {
            false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(getClass().getCanonicalName(), "Entramos en el Grid de descripción");
        ListView listaCompra = (ListView)findViewById(R.id.listaCompra);
        listaCompra.setAdapter(new AdapterCompra(this, listaArticulos, listaEstado));

        listaCompra.setOnItemClickListener (new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if(listaEstado[position]) {
                    v.setBackgroundColor(Color.WHITE);
                } else {
                    v.setBackgroundColor(Color.BLUE);
                }
                listaEstado[position] = !listaEstado[position];
            }
        });
    }
}
