# Google Play'e yükleme rehberi

## 1. GitHub'a Play anahtarının şifresini tanıt (bir kez)
Play'e yüklenecek paket (`.aab`) gizli bir anahtarla imzalanır. Anahtar depoda şifreli
(`app/upload.keystore.enc`) durur; şifresini GitHub'a sen tanıtırsın:

1. https://github.com/khanjui0/ger-ek-bir-proje/settings/secrets/actions/new adresini aç.
2. **Name:** `UPLOAD_KEY_PASSWORD`
3. **Secret:** sana sohbette verilen şifre
4. **Add secret**'e bas.
5. https://github.com/khanjui0/ger-ek-bir-proje/actions adresinde "Derle" iş akışını aç,
   **Run workflow** ile yeniden çalıştır.

Bundan sonra her sürümde **Releases** sayfasında `ASM-Cari-Hesaplama-PlayStore.aab` da çıkar.
Şifreyi güvenli bir yere not et; kaybolursa Play Console'dan "yükleme anahtarını sıfırla"
talebi gerekir.

## 2. Play Console hesabı
1. https://play.google.com/console adresinden geliştirici hesabı aç (tek seferlik 25 $).
2. Kimlik doğrulamasını tamamla.
3. Kişisel hesaplarda yeni uygulamalar, üretime çıkmadan önce **en az 12 test kullanıcısıyla
   14 gün kapalı test** zorunluluğuna tabidir. ASM'deki ve çevrendeki hekimleri test kullanıcısı
   olarak ekleyebilirsin.

## 3. Uygulamayı oluştur
1. **Uygulama oluştur** → ad: *ASM Cari Hesaplama*, dil: Türkçe, Uygulama, Ücretsiz.
2. **Uygulama içeriği** bölümü:
   - Gizlilik politikası: `MAGAZA-METINLERI.md` içindeki adres
   - Reklamlar: **Hayır, reklam içermiyor**
   - Uygulama erişimi: Tüm işlevler kısıtlama olmadan kullanılabilir
   - İçerik derecelendirmesi: anketi doldur (şiddet vb. hepsi "hayır")
   - Hedef kitle: 18 yaş ve üzeri
   - Veri güvenliği: **Uygulama kullanıcı verisi toplamıyor veya paylaşmıyor**
   - Kamu sağlığı/finans beyanları sorulursa: finansal hizmet sunmuyor, sadece hesap makinesi
3. **Mağaza girişi**: `MAGAZA-METINLERI.md` metinlerini ve bu klasördeki görselleri yükle.

## 4. Paketi yükle
1. **Test → Kapalı test** → yeni sürüm oluştur.
2. "Play Uygulama İmzalama" önerildiğinde kabul et.
3. Releases sayfasından indirdiğin `ASM-Cari-Hesaplama-PlayStore.aab` dosyasını yükle.
4. Test kullanıcılarını ekle, sürümü incelemeye gönder.
5. 14 gün sonra **Üretime erişim başvurusu** yap.

Yeni bir sürüm için: kod değişikliği gönderilince yeni `.aab` otomatik derlenir, sürüm numarası
kendiliğinden artar; Play Console'a yeni sürüm olarak yüklemek yeterli.
