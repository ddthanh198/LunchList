package com.jack.lunchlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListRestaurantAdapter extends ArrayAdapter<Restaurant> {
    private Context context;
    private int resource;
    private ArrayList<Restaurant> listRestaurants;

    public ListRestaurantAdapter( Context context, int resource, ArrayList objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listRestaurants = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RestaurantViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_restaurants, parent, false);
            holder = new RestaurantViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (RestaurantViewHolder) convertView.getTag();
        }

        holder.populateFrom(listRestaurants.get(position));
        return convertView;
    }

    class RestaurantViewHolder{
        private ImageView ivIcon;
        private TextView tvName;
        private TextView tvAddr;

        RestaurantViewHolder(View view){
            ivIcon = view.findViewById(R.id.iv_icon_restaurant);
            tvAddr = view.findViewById(R.id.tv_addr_item);
            tvName = view.findViewById(R.id.tv_name_item);
        }

        private void populateFrom(Restaurant restaurant){
            tvName.setText(restaurant.getName());
            tvAddr.setText(restaurant.getAddress());
            if(restaurant.getType().equals("Take out")){
                ivIcon.setImageResource(R.drawable.img_takeout);
            }else if(restaurant.getType().equals("Sit down")){
                ivIcon.setImageResource(R.drawable.img_sit_down);
            }else if(restaurant.getType().equals("Delivery")){
                ivIcon.setImageResource(R.drawable.img_delivery);
            }
        }
    }
}
