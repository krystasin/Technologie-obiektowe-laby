using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using System.Threading.Tasks;

namespace app
{

    class Vector2D 
    {


        private double x;
        private double y;

        public double X { get => x; set => x = value; }
        public double Y { get => y; set => y = value; }

        public Vector2D(double x, double y)
        {
            this.X = x;
            this.Y = y;
        }       

                                                                                                                               
        public double abs()
        {
            return Math.Sqrt(X * X + Y * Y);
        }
        public double cdot(Vector2D vector)
        {
            return (vector.X * X + vector.Y * Y);
        }
        public double[] getComponents()
        {
            double[] tab = { X, Y };
            return tab;
        }
        public double getAngle()
        {
            Vector2D ox = new Vector2D(1,0);
            double cosA = this.cdot(ox) / (this.abs() * ox.abs());
            return (180 / Math.PI) *  cosA;
        }

        public void chgangeDirection(bool b = false)
        {
            double temp = x;
            x = y;
            y = temp;
        }

    }




}
