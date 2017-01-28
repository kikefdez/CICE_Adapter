package com.quique.cice_adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Quique on 28/01/2017.
 */

public class AdapterCompra extends BaseAdapter {
    private Context contexto;
    private String[] listaArticulos;
    private Boolean[] listaEstados;

    public Context getContexto() { return contexto; }
    public void setContexto(Context valor) { this.contexto = valor; }
    public String[] getListaArticulos() { return listaArticulos; }
    public void setListaArticulos(String[] valor) { this.listaArticulos = valor; }
    public void setListaEstados(Boolean[] valor) { this.listaEstados = valor; }
    public Boolean[] getListaEstados() { return listaEstados; }

    public AdapterCompra(Context valorContexto, String[] valorArticulos, Boolean[] valorEstados ) {
        setContexto(valorContexto);
        setListaArticulos(valorArticulos);
        setListaEstados(valorEstados);
    }



    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() { return listaArticulos.length; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(getClass().getCanonicalName(), "Entramos en el adapter de los artículos");
        View nodoArticulo = new View(contexto);

        if(null == convertView){
            Activity activity = (Activity) contexto;
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            nodoArticulo = layoutInflater.inflate(R.layout.nodo_compra, parent, false);
            nodoArticulo.setTag(listaEstados[position]);
        } else {
            nodoArticulo = convertView;
        }
        if(listaEstados[position]){
            nodoArticulo.setBackgroundColor(Color.BLUE);
        } else{
            nodoArticulo.setBackgroundColor(Color.WHITE);
        }

        ((TextView)nodoArticulo.findViewById(R.id.nodoCompra)).setText(listaArticulos[position]);

        return nodoArticulo;
    }
}
