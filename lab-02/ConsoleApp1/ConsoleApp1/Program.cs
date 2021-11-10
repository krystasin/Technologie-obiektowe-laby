using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            IVector v = new Vector2D(2, 3);

            Console.WriteLine("x="+ v.x.get + "  " +v.abs());

            Console.ReadLine();
        }
    }
}
