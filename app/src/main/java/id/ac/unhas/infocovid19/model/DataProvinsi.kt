package id.ac.unhas.infocovid19.model

import com.google.gson.annotations.SerializedName

data class DataProvinsi(
    @SerializedName("provinsi")
    val data: List<Provinsi?>?
)

data class Provinsi(
    @SerializedName("fid")
    val fid: Int?,


    val kasusMeni: Int?,

    @SerializedName("kasusPosi")
    val kasusPosi: Int?,

    @SerializedName("kasusSemb")
    val kasusSemb: Int?,

    @SerializedName("kodeProvi")
    val kodeProvi: Int?,

    @SerializedName("provinsi")
    val provinsi: String?
) {
    override fun toString(): String {
        return "Provinsi ${this.provinsi} Kode: ${this.kodeProvi}, Positif: ${this.kasusPosi}, Meninggal: ${this.kasusMeni}, Sembuh:${this.kasusSemb}]"
    }
}
