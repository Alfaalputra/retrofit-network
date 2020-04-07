package id.ac.unhas.infocovid19.model

import com.google.gson.annotations.SerializedName

data class DataKasus(
    @SerializedName("kasus")
    val data: List<Kasus?>?
)

data class Kasus(
    @SerializedName("added_date")
    val added_date: String,

    @SerializedName("detail_wn")
    val detail_wn: Any,

    @SerializedName("garis_penularan")
    val garis_penularan: Any,

    @SerializedName("id_cluster")
    val id_cluster: Any,

    @SerializedName("id_kasus")
    val id_kasus: Any,

    @SerializedName("id_lab")
    val id_lab: Int,

    @SerializedName("id_pasien")
    val id_pasien: Int,

    @SerializedName("id_status")
    val id_status: Int,

    @SerializedName("jenis_kelamin")
    val jenis_kelamin: Int,

    @SerializedName("keterangan")
    val keterangan: Any,

    @SerializedName("keterangan_status")
    val keterangan_status: Any,

    @SerializedName("kode_pasien")
    val kode_pasien: Int,

    @SerializedName("lat")
    val lat: Any,

    @SerializedName("long")
    val long: Any,

    @SerializedName("provinsi")
    val provinsi: Int,

    @SerializedName("tampilkan")
    val tampilkan: Int,

    @SerializedName("umur")
    val umur: Int,

    @SerializedName("wn")
    val wn: Int
) {
    override fun toString(): String {
        return "Id Pasien: ${this.id_pasien}, Hasil Lab: ${this.id_lab}, Kode Pasien: ${this.kode_pasien}, Provinsi: ${this.provinsi}, Longitude: ${this.long}, Latitude: ${this.lat}, Jenis Kelamin: ${this.jenis_kelamin}, Umur: ${this.umur}, Cluster: ${this.id_cluster}, Keterangan: ${this.keterangan}, Status Pasien: ${this.keterangan}, Keterangan Status: ${this.keterangan_status}, Warga Negara: ${this.detail_wn}, Tanggal Masuk: ${this.added_date}, Garis Penularan: ${this.garis_penularan} "
    }
}