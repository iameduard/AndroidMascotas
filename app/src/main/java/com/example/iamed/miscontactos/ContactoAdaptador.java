package com.example.iamed.miscontactos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    public ContactoAdaptador(ArrayList<Contacto> contactos){
        this.contactos=contactos;
    }

    private ArrayList<Contacto> contactos;

    //Inflar el layout y lo pasara al viewholder para que obtenga los views..
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Indicar cual es el layout que estara reciclando el recycle view...
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_contacto,viewGroup,false);
        return new ContactoViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view..
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int i) {
        //Este metodo se va invocando uno a uno a medida que se va recorriendo la lista...
        Contacto contacto=contactos.get(i);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista de contactos...
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView  tvNombreCV;
        private TextView  tvTelefonoCV;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto     =(ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV  =(TextView)  itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV=(TextView)  itemView.findViewById(R.id.tvTelefonoCV);

        }
    }
}
