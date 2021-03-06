package com.asier.aranda.asierarandaexamen;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptadorSimple extends RecyclerView.Adapter<MiAdaptadorSimple.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater; //




    private int pos=0;
    public int getPos(){ return this.pos;}

    public String divisa = "";

    //constructor. pasamos los datos
    MiAdaptadorSimple(Context context, List<String> data){
        this.mInflater=LayoutInflater.from(context);
        this.mData=data;
    }

    //infla cada fila del layout que hemos hecho oara cada fila
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }


    //recupera la posicion del array en el que estamos y
    //asigna en TExtView el nombre del animal
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tvRecycled = view.findViewById(R.id.tvNombreDivisas);
                ColorDrawable viewColor = (ColorDrawable) tvRecycled.getBackground();
                if (viewColor == null)  {
                    tvRecycled.setBackgroundColor(Color.BLUE);
                }
                else {
                    int colorId = viewColor.getColor();
                    if (colorId == Color.WHITE) tvRecycled.setBackgroundColor(Color.BLUE);
                    else tvRecycled.setBackgroundColor(Color.WHITE);
                }
                pos=position;


//                TextView tvVerDivisaSelec = view.findViewById(R.id.tvVerDivisaSelec);
//                divisa=String.valueOf(tvRecycled.getText());
//
//                if (divisa.equalsIgnoreCase("USD")){
//
//                    tvVerDivisaSelec.setText(""+divisa);
//
//                }



            }
        });

    }


    //total numero de filas
    @Override
    public int getItemCount(){
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{//clase ViewHolder
        TextView myTextView;
        ViewHolder(View itemView){//construcotor
            super(itemView);
            myTextView=itemView.findViewById(R.id.tvNombreDivisas);
        }
    }
}
