package com.example.m3xml.data

import com.example.m3xml.R

object DataSource {
    fun getFilms(): List<Film> {
        return listOf(
            Film(
                1,
                "Unchanny Counter Season 1",
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
                R.drawable.duitheist, // ganti dengan nama file gambar Anda
                "https://www.imdb.com/title/tt13696452/?ref_=nv_sr_srsg_0_tt_8_nm_0_in_0_q_Money%2520Heist%2520Ko"
            ),
            Film(
                4,
                "My Name",
                "2021",
                "Setelah ayahnya dibunuh, seorang wanita yang ingin membalas dendam memutuskan untuk memercayai bos kriminal yang berkuasa—dan memasuki kepolisian atas petunjuk pria itu.",
                R.drawable.ngaran, // ganti dengan nama file gambar Anda
                "https://www.imdb.com/title/tt12940504/?ref_=nv_sr_srsg_3_tt_8_nm_0_in_0_q_My%2520Name"
            ),
            Film(
                5,
                "The 8 Show",
                "2024",
                "Indonesia's preeminent superhero and his alter ego Sancaka enter the cinematic universe to battle the wicked Pengkor and his orphan army.",
                R.drawable.delapan, // ganti dengan nama file gambar Anda
                "https://www.imdb.com/title/tt9201084/"
            )
        )
    }
}