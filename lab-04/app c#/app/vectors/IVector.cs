using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using System.Threading.Tasks;

namespace app
{
    interface IVector
    {

        Brush getColor();
        double x { get; set; }
        double y { get; set; }
        double abs();
        double cdot(IVector vector);
        /*        double[] getComponenents();*/

    }
}
