package com.ppsi.kraftindo;

import java.util.ArrayList;

public class ProdukData {
    private static String[] produkNames = {
            "Kopiah Sambas",
            "Syal Dayak",
            "Tanjak Melayu",
            "Tikar Pandan",
            "Piring Anyam",
            "Caping",
            "Raga",
            "Kain Batik",
            "Dompet Anyam",
            "Tas Kulit Kayu"
    };

    private static String[] produkDetail = {
            "Kain tenun merupakan salah satu warisan khas Kabupaten Sambas. Salah satu Desa yang memproduksi tenun yaitu desa Sembarang dan desa Jirak. Kain tenun ini diproduksi lagi menjadi berbagai bentuk salah satunya kopiah.",
            "Syal dayak bermotif suai berkait yang artinya Dayak, Cina, dan Melayu saling berkait. Sedangkan syal Melayu mempunyai motif corak insang dan awan berarak.",
            "Salah satu ciri khas kaum adam Melayu adalah adanya lilitan kain di kepala yang biasa disebut dengan Tanjak. Tanjak sendiri dianggap sebagai lambang kewibawaan masyarakat Melayu.",
            "Tikar pandan ini juga di olah dalam berbagai bentuk seperti tas laptop, tas, tudung saji, tempat tisu dan lainnya.",
            "Piring anyaman terbuat dari bambu yang dicat dengan pelitur warna kayu dimana ukuran piring anyaman dari bambu adalah Diameter 24 - 25cm.",
            "Caping merupakan anyaman topi kerucut yang terbuat dari bambu untuk melindungi kepala dari teriknya sinar matahari",
            "Raga merupakan anyaman rotan khas masyrakat dayak bidayuh yang berbentuk tas belanja berkualitas.",
            "Kain batik Cina - Dayak - Melayu khas kalimantan barat dengan motif indah yang dapat dibuat menjadi berbagai macam sandang.",
            "Dompet anyaman yang terbuat dari daun pandan berkualitas dengan ketahanan tinggi dan ramah lingkungan",
            "Tas kecil dari kulit kayu ramah lingkungan yang cocok digunakan saat berekreasi dan jalan santai"
    };

    private static int[] produkImages = {
            R.drawable.kopiahsambas,
            R.drawable.syaldayak,
            R.drawable.tanjakmelayu,
            R.drawable.tikarpandan,
            R.drawable.piringlidi,
            R.drawable.caping,
            R.drawable.keranjanganyam,
            R.drawable.batik,
            R.drawable.dompet,
            R.drawable.taskayu
    };

    private static String[] produkHarga = {
            "25000",
            "50000",
            "250000",
            "200000",
            "5000",
            "20000",
            "120000",
            "90000",
            "25000",
            "30000"

    };

    public static ArrayList<Produk> getListData() {
        ArrayList<Produk> list = new ArrayList<>();
        for (int position = 0; position < produkNames.length; position++) {
            Produk produk = new Produk();
            produk.setName(produkNames[position]);
            produk.setDetail(produkDetail[position]);
            produk.setHarga(produkHarga[position]);
            produk.setPhoto(produkImages[position]);
            list.add(produk);
        }
        return list;
    }
}