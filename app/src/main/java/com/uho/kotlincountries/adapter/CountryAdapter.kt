package com.uho.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation

import androidx.recyclerview.widget.RecyclerView
import com.uho.kotlincountries.R
import com.uho.kotlincountries.databinding.ItemCountryBinding
import com.uho.kotlincountries.model.Country
import com.uho.kotlincountries.util.downloadFromUrl
import com.uho.kotlincountries.util.placeholderProgressBar
import com.uho.kotlincountries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.fragment_country.view.*
import kotlinx.android.synthetic.main.item_country.view.*
import kotlinx.android.synthetic.main.item_country.view.countryName

class CountryAdapter(private val countryList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),CountryClickListener{

    class CountryViewHolder(var view: ItemCountryBinding): RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_country,parent,false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countryList[position]
        holder.view.clickedListener = this
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val id = v.countryId.text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(id)
        Navigation.findNavController(v).navigate(action)
    }
}