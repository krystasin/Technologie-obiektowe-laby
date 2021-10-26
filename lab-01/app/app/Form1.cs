using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Text.RegularExpressions;

namespace app
{
    public partial class Form1 : Form
    {


        private Singleton s = Singleton.GetSingleton();

        private Regex reg = new Regex(@"^\d*,?\d?\d?$");



        public Form1()
        {
            InitializeComponent();
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            s.kantor.loadData();
            List<Waluta> waluty2 = new List<Waluta>(s.kantor.waluty);
         
            waluta_list_from.DataSource = s.kantor.waluty;
            waluta_list_to.DataSource = waluty2;

        }




        private void waluta_list_to_SelectionChangeCommitted(object sender, EventArgs e)        {
            waluta_form_out.Text = wyliczBEDOES();
        }

        private void waluta_list_from_SelectionChangeCommitted(object sender, EventArgs e)        {
            waluta_form_out.Text = wyliczBEDOES();
        }

        private void waluta_form_in_TextChanged(object sender, EventArgs e)        {
            waluta_form_out.Text = wyliczBEDOES();
        }

        private string wyliczBEDOES()
        {
            if (waluta_form_in == null) return "";
            Waluta wf = (Waluta)waluta_list_from.SelectedItem;
            Waluta wt = (Waluta)waluta_list_to.SelectedItem;
            try
            {
                double wynik = double.Parse(waluta_form_in.Text);
                wynik = wynik * wf.Kurs / wf.Przelicznik * wt.Przelicznik / wt.Kurs;
                wynik = Math.Round(wynik, 2);
                return wynik.ToString() + " " + wt.Kod;
            }
            catch (Exception e)
            {
              //  Console.WriteLine(e);
            }

            return "";
        }

        private void waluta_form_in_Enter(object sender, EventArgs e)
        {
           Console.WriteLine("kriopee kszton");
        }

        private void waluta_form_in_KeyPress(object sender, KeyPressEventArgs e)
        {

            if ((int)e.KeyChar == 46) 
                e.KeyChar = (char)44;
           //   Console.WriteLine("kriopee kszton");


            if (e.KeyChar != (char)Keys.Back && e.KeyChar != (char)Keys.Delete)
                if (!reg.IsMatch(waluta_form_in.Text + e.KeyChar))    
                    e.Handled = true;

        }
    }
}
