package id.ac.unhas.infocovid19.model

import com.google.gson.annotations.SerializedName

data class DataHarian(
    @SerializedName("harian")
    val data: List<Harian?>?
)

data class Harian(
    @SerializedName("fid")
    val fid: Int,

    @SerializedName("harike")
    val harike: Int,

    @SerializedName("jumlahKasusBaruperHari")
    val jumlahKasusBaruperHari: Int,

    @SerializedName("jumlahKasusDirawatperHari")
    val jumlahKasusDirawatperHari: Int,

    @SerializedName("jumlahKasusKumulatif")
    val jumlahKasusKumulatif: Int,

    @SerializedName("jumlahKasusMeninggalperHari")
    val jumlahKasusMeninggalperHari: Int,

    @SerializedName("jumlahKasusSembuhperHari")
    val jumlahKasusSembuhperHari: Int,

    @SerializedName("jumlahPasienMeninggal")
    val jumlahPasienMeninggal: Int,

    @SerializedName("jumlahPasienSembuh")
    val jumlahPasienSembuh: Int,

    @SerializedName("jumlahpasiendalamperawatan")
    val jumlahpasiendalamperawatan: Int,

    @SerializedName("persentasePasienMeninggal")
    val persentasePasienMeninggal: Int,

    @SerializedName("persentasePasienSembuh")
    val persentasePasienSembuh: Int,

    @SerializedName("persentasePasiendalamPerawatan")
    val persentasePasiendalamPerawatan: Int,

    @SerializedName("tanggal")
    val tanggal: Long
){
    override fun toString(): String {
        return "Hari Ke: ${this.harike}, Tanggal: ${this.tanggal}, Jumlah Kasus Baru Perhari: ${this.jumlahKasusBaruperHari}, Jumlah Kasus Kumulatif: ${this.jumlahKasusKumulatif}, Jumlah Pasien Dalam Perawatan: ${this.jumlahpasiendalamperawatan}, Persentase Pasien Dalam Perawatan: ${this.persentasePasiendalamPerawatan}, Jumlah Pasien Sembuh: ${this.jumlahPasienSembuh}, Persentase Pasien Sembuh: ${this.persentasePasienSembuh}, Jumlah Pasien Meninggal: ${this.jumlahPasienMeninggal}, Persentase Pasien Meninggal: ${this.persentasePasienMeninggal}, Jumlah Kasus Sembuh Perhari: ${this.jumlahKasusSembuhperHari}, Jumlah Kasus Meninggal Perhari: ${this.jumlahKasusMeninggalperHari}, Jumlah Kasus Dirawat Perhari: ${this.jumlahKasusDirawatperHari}"
    }
}