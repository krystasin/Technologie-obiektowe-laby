using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{

    class Vector2D : IVector
    {
        public double x { get; set; }
        private double y;

        public Vector2D(double x, double y)
        {
            this.x = x;
            this.y = y;
        }



        public double abs()
        {
            return Math.Sqrt(x*x+y*y);
        }
        public double cdot(IVector vector)
        {
            return 0;
        }
        


    }

 


}
