
Ini adalah aplikasi untuk memenuhi tugas Interview PT Inovasi Daya Solusi
build tools : maven 
Versi Java  : 1.8
Path GET    : /*
              (ini untuk get semua data yang ada pad file JSON)
Port        : 4448 (default)
               Bisa dirubah dengan menjalankan -port={{PORT}} 
               Ex : -port=8087

Database    : data-sql.sql
              Data import manual karena didalamnya ad query untuk create tabel yang diperlukan, karena ada kemungkinan aplikasi diberi akses databse yang tidak diizinkan  create database dan tabel.
Setting     : com.webservice.database.DatabaseHelper (tempat mensetting database user password), ini hardcode.
