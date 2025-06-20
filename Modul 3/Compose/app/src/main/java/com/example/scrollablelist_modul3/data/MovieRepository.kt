package com.example.scrollablelist_modul3.data


import com.example.scrollablelist_modul3.R
import com.example.scrollablelist_modul3.model.Movie

object MovieRepository {
    fun getMovies(): List<Movie> {
        return listOf(
            Movie(
                title = "Uncanny Counter Season 1",
                year = "2020",
                plot = "Para Counter yang karyawan toko mi di siang hari dan pemburu iblis di malam hari, memakai berbagai kemampuan khusus untuk memburu roh-roh jahat yang mengincar manusia.",
                imdb = "https://www.imdb.com/title/tt13273826/",
                posterResId = R.drawable.dukun
            ),
            Movie(
                title = "Sweet Home Season 1",
                year = "2020",
                plot = "Saat banyak manusia berubah menjadi monster ganas dan dunia terpuruk ke dalam teror, sekelompok penyintas berjuang untuk hidup—dan mempertahankan kemanusiaan mereka..",
                imdb = "https://www.imdb.com/title/tt11612120/?ref_=nv_sr_srsg_0_tt_8_nm_0_in_0_q_Sweet%2520Home",
                posterResId = R.drawable.rm
            ),
            Movie(
                title = "Money Heist Korea",
                year = "2022",
                plot = "Pencuri menguasai gedung percetakan uang milik Korea bersatu dan menawan banyak sandera. Polisi harus menghentikan aksi mereka, serta dalang yang bersembunyi di baliknya.",
                imdb = "https://www.imdb.com/title/tt13696452/?ref_=nv_sr_srsg_0_tt_8_nm_0_in_0_q_Money%2520Heist%2520Ko",
                posterResId = R.drawable.duitheist
            ),
            Movie(
                title = "My Name",
                year = "2021",
                plot = "Setelah ayahnya dibunuh, seorang wanita yang ingin membalas dendam memutuskan untuk memercayai bos kriminal yang berkuasa—dan memasuki kepolisian atas petunjuk pria itu.",
                imdb = "https://www.imdb.com/title/tt12940504/?ref_=nv_sr_srsg_3_tt_8_nm_0_in_0_q_My%2520Name",
                posterResId = R.drawable.ngaran
            ),
            Movie(
                title = "The 8 Show",
                year = "2024",
                plot = "Delapan orang yang terjebak di gedung delapan lantai misterius mengikuti acara yang menarik tetapi berbahaya. Dengan berjalannya waktu, mereka akan mendapat hadiah uang.",
                imdb = "https://www.imdb.com/title/tt30423279/?ref_=nv_sr_srsg_0_tt_8_nm_0_in_0_q_The%25208%2520Show",
                posterResId = R.drawable.delapan
            ),
            Movie(
                title = "Kingdom Season 1",
                year = "2020",
                plot = "Saat rumor aneh tentang raja yang sakit menguasai kerajaan, putra mahkota menjadi satu-satunya harapan mereka untuk melawan wabah misterius yang menjangkiti negeri.",
                imdb = "https://www.imdb.com/title/tt6611916/?ref_=nv_sr_srsg_6_tt_8_nm_0_in_0_q_Kingdom",
                posterResId = R.drawable.raja
            ),
            Movie(
                title = "The Frog",
                year = "2024",
                plot = "Di musim panas nan damai, seorang wanita misterius masuk ke sebuah penginapan—memicu beragam peristiwa yang mengganggu kehidupan si pemilik dan orang-orang di sekitarnya.",
                imdb = "https://www.imdb.com/title/tt26767508/",
                posterResId = R.drawable.frog
            ),
            Movie(
                title = "All of Us Are Dead",
                year = "2022",
                plot = "Sebuah SMA menjadi titik nol merebaknya wabah virus zombi. Para murid yang terperangkap pun harus berjuang untuk kabur jika tak mau terinfeksi dan berubah menjadi buas.",
                imdb = "https://www.imdb.com/title/tt14169960/",
                posterResId = R.drawable.allofus
            ),
            Movie(
                title = "Taxi Driver",
                year = "2021",
                plot = "Seorang sopir taksi di Seoul mengantar seorang wartawan Jerman untuk menyelidiki isu kerusuhan di Gwangju tanpa tahu apa yang menanti mereka. Berdasarkan kisah nyata.",
                imdb = "https://www.imdb.com/title/tt13759970/",
                posterResId = R.drawable.taxi
            ),
            Movie(
                title = "A Killer Paradox",
                year = "2024",
                plot = "Saat suatu pembunuhan tak disengaja memunculkan pembunuhan serupa lainnya, pemuda biasa ini terjebak dalam aksi kucing-kucingan tanpa henti dengan detektif yang lihai.",
                imdb = "https://www.imdb.com/title/tt28642796/",
                posterResId = R.drawable.paradox
            )
        )
    }
}
