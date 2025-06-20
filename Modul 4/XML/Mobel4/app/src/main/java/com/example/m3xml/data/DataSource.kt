package com.example.m3xml.data

import com.example.m3xml.R

object DataSource {
    fun getFilms(): List<Film> {
        return listOf(
            Film(
                1,
                "Unchanny Counter",
                "2020",
                "Para Counter yang karyawan toko mi di siang hari dan pemburu iblis di malam hari, memakai berbagai kemampuan khusus untuk memburu roh-roh jahat yang mengincar manusia.",
                R.drawable.dukun,
                "https://www.imdb.com/title/tt13273826/"
            ),
            Film(
                2,
                "Sweet Home",
                "2020",
                "Saat banyak manusia berubah menjadi monster ganas dan dunia terpuruk ke dalam teror, sekelompok penyintas berjuang untuk hidup—dan mempertahankan kemanusiaan mereka.",
                R.drawable.rm,
                "https://www.imdb.com/title/tt11612120/?ref_=nv_sr_srsg_0_tt_8_nm_0_in_0_q_Sweet%2520Home"
            ),
            Film(
                3,
                "Money Heist Korea",
                "2022",
                "Pencuri menguasai gedung percetakan uang milik Korea bersatu dan menawan banyak sandera. Polisi harus menghentikan aksi mereka, serta dalang yang bersembunyi di baliknya.",
                R.drawable.duitheist,
                "https://www.imdb.com/title/tt13696452/?ref_=nv_sr_srsg_0_tt_8_nm_0_in_0_q_Money%2520Heist%2520Ko"
            ),
            Film(
                4,
                "My Name",
                "2021",
                "Setelah ayahnya dibunuh, seorang wanita yang ingin membalas dendam memutuskan untuk memercayai bos kriminal yang berkuasa—dan memasuki kepolisian atas petunjuk pria itu.",
                R.drawable.ngaran,
                "https://www.imdb.com/title/tt12940504/?ref_=nv_sr_srsg_3_tt_8_nm_0_in_0_q_My%2520Name"
            ),
            Film(
                5,
                "The 8 Show",
                "2024",
                "Delapan orang yang terjebak di gedung delapan lantai misterius mengikuti acara yang menarik tetapi berbahaya. Dengan berjalannya waktu, mereka akan mendapat hadiah uang.",
                R.drawable.delapan,
                "https://www.imdb.com/title/tt9201084/"
            ),
            Film(
                6,
                "Taxi Driver",
                "2021",
                "Seorang sopir taksi di Seoul mengantar seorang wartawan Jerman untuk menyelidiki isu kerusuhan di Gwangju tanpa tahu apa yang menanti mereka. Berdasarkan kisah nyata.",
                R.drawable.taxi,
                "https://www.imdb.com/title/tt13759970/"
            ),
            Film(
                7,
                "Kingdom",
                "2020",
                "Saat rumor aneh tentang raja yang sakit menguasai kerajaan, putra mahkota menjadi satu-satunya harapan mereka untuk melawan wabah misterius yang menjangkiti negeri.",
                R.drawable.raja,
                "https://www.imdb.com/title/tt6611916/?ref_=nv_sr_srsg_6_tt_8_nm_0_in_0_q_Kingdom"
            ),
            Film(
                8,
                "The Frong",
                "2024",
                "Di musim panas nan damai, seorang wanita misterius masuk ke sebuah penginapan—memicu beragam peristiwa yang mengganggu kehidupan si pemilik dan orang-orang di sekitarnya.",
                R.drawable.frog,
                "https://www.imdb.com/title/tt26767508/"
            ),
            Film(
                9,
                "All of Us Are Dead",
                "2022",
                "Sebuah SMA menjadi titik nol merebaknya wabah virus zombi. Para murid yang terperangkap pun harus berjuang untuk kabur jika tak mau terinfeksi dan berubah menjadi buas.",
                R.drawable.allofus,
                "https://www.imdb.com/title/tt14169960/"
            ),
            Film(
                10,
                "A Killer Paradox",
                "2024",
                "Saat suatu pembunuhan tak disengaja memunculkan pembunuhan serupa lainnya, pemuda biasa ini terjebak dalam aksi kucing-kucingan tanpa henti dengan detektif yang lihai.",
                R.drawable.paradox,
                "https://www.imdb.com/title/tt28642796/"
            )
        )
    }
}