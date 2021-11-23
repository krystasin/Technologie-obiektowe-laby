using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Threading;

namespace app
{
    public partial class Form1 : Form
    {
        public static readonly int czasZakazenia = 75;
        public static readonly int StepsPerSecond = 25;
        private int ballSize = 10;
        Thread th;
        Graphics g;
        Graphics fG;
        Bitmap btm;

        private List<Jednostka> jednostki = new List<Jednostka>();
        static int iloscOsobnikow = 200;
        private double xSize = 50, ySize = 50;
        private double xRate, yRate;
        private Momento momento = new Momento();


        public Form1()
        {
            InitializeComponent();
//            Console.WriteLine($"xRate {xRate}  \t yRate: {yRate}");

            g = drawArea.CreateGraphics();
            fG = CreateGraphics();
   
            xRate = (drawArea.Width - 1) / xSize;
            yRate = (drawArea.Height - 1) / ySize;
        }



        private void createMemento(int nrZapisu)
        {
            momento.create(nrZapisu,jednostki);
        }


        private void draw(object sender, PaintEventArgs e)
        {
            int ii = 0;
            while (true)
            {
                ii++;
                noweJednostki();
                obliczenia();

                //   g.Clear(Color.FromArgb(20, 20, 20));
                   g.Clear(Color.Black);
             //   g.Background = new SolidColorBrush(Color.FromRgb(redColor, 0x0, blueColor));
                foreach (Jednostka item in jednostki)
                    g.FillEllipse(item.getColor(), (int)(item.Position.X * xRate - ballSize / 2), (int)(item.Position.Y * yRate - ballSize / 2), ballSize, ballSize);

          
                wait(1000/ Form1.StepsPerSecond); 
                if(ii == 25) {
                    Console.WriteLine(Form1.iloscOsobnikow);
                    ii = 0;
                }
            }
        }
















        private void obliczenia()
        {
            foreach (var item in jednostki)
                item.checkIfInfected(jednostki);
            
            foreach (var item in jednostki) {
                item.randomMovementChange();
                item.changePosition();
            }

            //  usuwanie jednostek z poza obszaru
            foreach (var item in jednostki.Reverse<Jednostka>()) {
                if (item.checkIfOut(xSize, ySize)) {
                    jednostki.Remove(item);
                    Form1.iloscOsobnikow--;
                }
            }

        }
        private void restore(int i)
        {
            try
            {
                jednostki = momento.restore(i);
            }
            catch (Exception)
            {
                Console.WriteLine("nieudane ładowanie zapisu");
            }
        }




        private void Form1_Load(object sender, EventArgs e)
        {

            Random rand = new Random();
            for (int i = 0; i < iloscOsobnikow; i++)
            {
                Position position = new Position((int)(xSize / 2), (int)(ySize / 2));
                Movement movment = new Movement(rand.NextDouble(), rand.NextDouble());
                if (rand.NextDouble() < 0.5) movment.X *= -1;
                if (rand.NextDouble() < 0.5) movment.Y *= -1;
                jednostki.Add(new Jednostka(position, movment, rand.NextDouble() * 2 + 0.5));
                jednostki[i].Movement.Standarize();
            }
        }


        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {
          

        }

        private void button1_Click(object sender, EventArgs e)
        {
            createMemento(1);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            createMemento(2);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            createMemento(3);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            createMemento(4);
        }

        private void restore1_Click(object sender, EventArgs e)
        {
            restore(1);
        }

        private void restore2_Click(object sender, EventArgs e)
        {
            restore(2);
        }

        private void restore3_Click(object sender, EventArgs e)
        {
             restore(3);
        }

        private void restore4_Click(object sender, EventArgs e)
        {
            restore(4);
        }

        public void wait(int milliseconds)
        {
            var timer1 = new System.Windows.Forms.Timer();
            if (milliseconds == 0 || milliseconds < 0) return;

            // Console.WriteLine("start wait timer");
            timer1.Interval = milliseconds;
            timer1.Enabled = true;
            timer1.Start();

            timer1.Tick += (s, e) =>
            {
                timer1.Enabled = false;
                timer1.Stop();
                // Console.WriteLine("stop wait timer");
            };

            while (timer1.Enabled)
            {
                Application.DoEvents();
            }
        }

        private void noweJednostki()
        {
            Random rand = new Random();
            if(rand.Next(5) == 0)
            {
                Movement movment = new Movement(rand.NextDouble(), rand.NextDouble());
                
                Position position;
                int r = rand.Next(4);
                if (r == 0)
                {
                    position = new Position(0, rand.Next((int)ySize));

                } 
                else if (r == 1)
                {
                    position = new Position( rand.Next((int)xSize), (int)ySize);
                }
                else if (r==2)
                {
                    position = new Position((int)xSize, rand.Next((int)ySize));
                }
                else
                    position = new Position(rand.Next((int)xSize), 0);

                //todo dorobic tu ew w Movement.changeDirection zeby celował wektor w środek
                    
  
                jednostki.Add(new Jednostka(position, movment, rand.NextDouble() * 2 + 0.5, new Objawowy()));
                Form1.iloscOsobnikow++;
             //   Console.WriteLine("stworzone nowego");
            }


        }

    }
}
