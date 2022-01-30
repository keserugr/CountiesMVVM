package com.uho.kotlincountries.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "country")
data class Country(
    @ColumnInfo(name = "country_name")
    @SerializedName("name")
    val countryName: String?,

    @ColumnInfo(name = "country_region")
    @SerializedName("region")
    val countryRegion: String?,

    @ColumnInfo(name = "country_capital")
    @SerializedName("capital")
    val countryCapital: String?,

    @ColumnInfo(name = "country_currency")
    @SerializedName("currency")
    val countryCurrency: String,

    @ColumnInfo(name = "country_flag")
    @SerializedName("flag")
    val countryFlag: String,

    @ColumnInfo(name = "country_language")
    @SerializedName("language")
    val countryLanguage: String
) {
    @PrimaryKey(autoGenerate = true)
    var uId: Long = 0
}
