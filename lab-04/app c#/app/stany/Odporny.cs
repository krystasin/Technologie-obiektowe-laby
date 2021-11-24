using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
namespace app
{
    class Odporny : State
    {


        public void kontakt(List<Jednostka> list, Jednostka j)
        {
        }

        public Brush getColor() => Brushes.LightGreen;

        public State newInstance() => new Odporny();

        public bool czyZakazi() => false;
    }
}
