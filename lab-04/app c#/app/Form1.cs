using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace app
{
    public partial class Form1 : Form
    {
        private Graphics g;
        private Pen pen;

        private List<IVector> vectors = new List<IVector>();
    

        public Form1()
        {
            InitializeComponent();
            g = drawArea.CreateGraphics();
            pen = new Pen(Color.Red);
            this.Width = 800;
            this.Height= 600;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
/*
            vectors.Add(new Vector2D(60, 100, new Odporny()));
            vectors.Add(new Vector2D(60, 200, new Zdrowy()));
            vectors.Add(new Vector2D(60, 300, new Objawowy()));
            vectors.Add(new Vector2D(60, 400, new BezObjawowy()));

*/
            Random random = new Random();
            for(int i=0; i<50; i++)
            {
            
                vectors.Add(new Vector2D( random.NextDouble()*600 , random.NextDouble()*600, new Odporny()));
            }



        }



        private void draw(object sender, PaintEventArgs e)
        {
            g.Clear(Color.Gray);

            Point p = new Point(20, 40);

            foreach (IVector v in vectors) {
                g.FillEllipse(v.getColor(), (int)v.x -5 , (int)v.y-5, 10, 10);
            }

        }

    }
}
