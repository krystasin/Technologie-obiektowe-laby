using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace app
{
    internal static class Program
    {
        /// <summary>
        /// Główny punkt wejścia dla aplikacji.
        /// </summary>
        [STAThread]
        static void Main()
        {


            List<Jednostka> j1 = new List<Jednostka>();
            j1.Add(new Jednostka(new Position(2,2), new Movement(2,2)));
            j1.Add(new Jednostka(new Position(3,3), new Movement(2,2)));
            j1[1].Position.X = 10;
            List<Jednostka> j2 = new List<Jednostka>(j1);
            foreach (var item in j2)
            {
                Console.WriteLine(item.Position.X);
            }





            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());

 

        }
    }
}
