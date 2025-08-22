
<h3>Ini adalah aplikasi untuk memenuhi tugas Interview PT Inovasi Daya Solusi</h3>
<br>build tools : maven 
<br>Versi Java  : 1.8
<br>Path GET    : /*
<br>              (ini untuk get semua data yang ada pad file JSON)
<br>Port        : 4448 (default)
<br>               Bisa dirubah dengan menjalankan -port={{PORT}} 
<br>               Ex : java -jar WebserviceTest-1.0-jar-with-dependencies.jar -port=8087 
<br>               (Ini jika aplikasi telah di Build with Dependencies)
<br>
<br>Database    : data-sql.sql
<br>              Data import manual karena didalamnya ad query untuk create tabel yang diperlukan, karena ada kemungkinan aplikasi diberi akses databse yang tidak diizinkan  create database dan tabel.
<br>Setting     : com.webservice.database.DatabaseHelper (tempat mensetting database user password), ini hardcode.
