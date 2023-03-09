import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
/**
 *
 * @author 4715
 */
public class Pajak {
   public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

            String nama;
            int jum, gol, jml_tnj_a, gapok, status, anak;
            double b_jabatan, b_pensiun, totpajak, gajibersih, jml_tnj_i, tunj_j, tunj_i, tunj_a, totgaji, pot,neto, ptkp, pkp, pp, k, k0, k1, pph, pph_b ;
            String nikah;
            

            System.out.println("-------------------------------------------------");
            System.out.println("  PROGRAM MENGHITUNG PAJAK PENGHASILAN KARYAWAN  ");
            System.out.println("-------------------------------------------------");

            System.out.print("Masukan Nama          : ");
            nama=input.next();
            System.out.println("Golongan 1/ 2/ 3/ 4");
            System.out.print("Masukan Golongan      : ");
            gol=input.nextInt();
            
            if (gol>4 || gol<1){
                System.out.println("Input Golongan Salah");
            }else{
            System.out.println("Status Nikah");
            System.out.println("1.Belum Menikah");
            System.out.println("2.Menikah");
            System.out.print("Ketik 1 / 2           : ");
            status = input.nextInt();
            System.out.print("Jumlah Anak           : ");
            anak=input.nextInt();
            
            switch(gol){
                case 1 : 
                        gapok=2686500;
                        tunj_i=gapok*0.05;
                        tunj_a=gapok*0.02;
                        tunj_j=5361800;
                        break;
                case 2 :
                        gapok=3820000;
                        tunj_i=gapok*0.05;
                        tunj_a=gapok*0.02;
                        tunj_j=7171875;
                        break;
                case 3 :
                        gapok=4797000;
                        tunj_i=gapok*0.05;
                        tunj_a=gapok*0.02;
                        tunj_j=7673375;
                        break;
                case 4 :
                        gapok=5901200;
                        tunj_i=gapok*0.05;
                        tunj_a=gapok*0.02;
                        tunj_j=8211000;
                        break;
                default :
                        gapok=0;
                        tunj_i=0;
                        tunj_a=0;
                        tunj_j=0;
            }
            
            
            
            if (anak>=3){
                jml_tnj_a= (int) (3*tunj_a);
                k1 = 3*4500000;
            }else{
                 jml_tnj_a= (int) (anak * tunj_a);
                k1 = anak*4500000;
            }
           
            if (status!=1){
                nikah="Kawin";
                jml_tnj_i= tunj_i;
                k0 = 4500000;
                k = 54000000;
            }else{
                jml_tnj_i= 0;
                nikah="Belum Kawin";
                k = 54000000;
                k0=0;
            }

            formatRp.setCurrencySymbol("Rp. ");
            formatRp.setMonetaryDecimalSeparator(',');
            formatRp.setGroupingSeparator('.');
            kursIndonesia.setDecimalFormatSymbols(formatRp);
            
            totgaji = gapok+jml_tnj_a+jml_tnj_i+tunj_j;
            b_jabatan = totgaji*0.05;
            b_pensiun = totgaji*0.01;
            pot= b_jabatan+b_pensiun;
            gajibersih=totgaji-pot;
            
            neto = gajibersih*12;
            ptkp = k+k0+k1;
            pkp = neto-ptkp;
            pph=0;
            if (pkp<50000000){
                pph=0.05;
            }else if(pkp<=250000000){
                pph=0.15;
            }else if(pkp<=500000000){
                pph=0.25;
            }else if(pkp>500000000){
                pph=0.5;
            }
            totpajak = pkp*pph;
            pph_b= totpajak/12;
            System.out.println("==============================================================");
            System.out.println("                    PENGHASILAN KARYAWAN                      ");
            System.out.println("==============================================================");
            System.out.println("Nama                 : "+nama);
            System.out.println("Golongan             : "+gol);
            System.out.println("Status Perkawinan    : "+nikah);
            System.out.println("Jumlah Anak          : "+anak);
            System.out.println("==============================================================");
            System.out.println("Gaji Pokok           : "+kursIndonesia.format(gapok));
            System.out.println("Tunjangan Istri      : "+kursIndonesia.format(jml_tnj_i));
            System.out.println("Tunjangan Anak       : "+kursIndonesia.format(jml_tnj_a));
            System.out.println("Tunjangan Jabatan    : "+kursIndonesia.format(tunj_j));
            System.out.println("________________________________________+");
            System.out.println("Total Gaji           :                      "+kursIndonesia.format(totgaji));
            System.out.println(" ");
            System.out.println("Potongan");
            System.out.println("Biaya Pensiun        : "+kursIndonesia.format(b_pensiun));
            System.out.println("Biaya Jabatan        : "+kursIndonesia.format(b_jabatan));
            System.out.println("________________________________________+");
            System.out.println("Biaya Jabatan        :                      "+kursIndonesia.format(pot));
            System.out.println("______________________________________________________________-");
            System.out.println("Gaji Diterima        :                      "+kursIndonesia.format(gajibersih));
            System.out.println("==============================================================");
            System.out.println(" ");
            System.out.println("==============================================================");
            System.out.println("           PERHITUNGAN PAJAK PENGHASILAN KARYAWAN             ");
            System.out.println("==============================================================");
            System.out.println("Pendapatan perbulan: "+kursIndonesia.format(gajibersih));
            System.out.println("Pendapatan Setahun :                        "+kursIndonesia.format(neto));
            System.out.println("========================================");
            System.out.println("PTKP Pribadi       : "+kursIndonesia.format(k));
            System.out.println("PTKP Istri         : "+kursIndonesia.format(k0));
            System.out.println("PTKP Anak("+anak+")       : "+kursIndonesia.format(k1));
            System.out.println("________________________________________+");
            System.out.println("Total PTKP         :                        "+kursIndonesia.format(ptkp));
            System.out.println("______________________________________________________________-");
            System.out.println("Jumlah PKP Setahun :                        "+kursIndonesia.format(pkp));
            System.out.println("==============================================================");
            System.out.println("                        PPh Pasal 21                          ");
            System.out.println("==============================================================");
            System.out.println("Jumlah PKP Setahun "+kursIndonesia.format(pkp)+" x "+pph+" = " +kursIndonesia.format(totpajak));
            System.out.println(" ");
            System.out.println("PPh yang harus di bayar pertahun: "+kursIndonesia.format(totpajak));
            System.out.println("PPh yang harus di bayar perbulan: "+kursIndonesia.format(pph_b));
            System.out.println("==============================================================");
            }
  }         
}
