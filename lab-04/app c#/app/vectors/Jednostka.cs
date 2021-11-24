using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
namespace app
{
    class Jednostka 
    {
        private State state;
        private Position position;
        private Movement movement;
        public double velosity;
        private int infectedTimeSteps = 0;
        private int infectedMaxTimeSteps = 20 * 25;
        public Dictionary<Jednostka, int> dictionary = new Dictionary<Jednostka, int>();



        public Jednostka(Position position, Movement movement, double velosity, State state)
        {
            this.movement = movement;
            this.state = state;
            this.position = position;
            this.velosity = velosity;
        }
        public Jednostka(Position position, Movement movement, double velosity)
        {
            this.movement = movement;
            this.state = new Zdrowy(); ;
            this.position = position;
            this.velosity = velosity;
        }
        public Jednostka(Position position, Movement movement)
        {
            this.state = new Zdrowy();
            this.movement = movement;
            this.position = position;
            this.velosity = 1;
        }
                
        public Jednostka(Jednostka j)
        {
            this.state = j.state.newInstance();
            this.movement = new Movement(j.movement);
            this.position = new Position(j.position);
            this.velosity = j.velosity;
            dictionary = new Dictionary<Jednostka, int>();
            foreach (var item in j.dictionary)
            {
                dictionary.Add(item.Key, item.Value);
            }

        }




        internal Position Position { get => position; set => position = value; }
        internal Movement Movement { get => movement; set => movement = value; }
        public int InfectedMaxTimeSteps { get => infectedMaxTimeSteps; set => infectedMaxTimeSteps = value; }
        public int InfectedTimeSteps { get => infectedTimeSteps; set => infectedTimeSteps = value; }
        public State State { get => state; set => state = value; }

        public void checkIfInfected(List<Jednostka> jednostki)
        {
            state.kontakt(jednostki, this);
        }




        public Brush getColor()
        {
            return state.getColor();
        }

        

        public void changePosition()
        {
            position.changePosition(movement, velosity);

        }

        public bool checkIfOut(double xSize, double ySize)
        {
            if (position.X < 0 || position.Y < 0 || position.X > xSize || position.Y > ySize)
            {
                Random random = new Random();
                if (random.Next(2) == 1)
                {
                    // odbij do centrum
                    if (position.X < 0 || position.X > xSize) movement.X *= -1;
                    else movement.Y *= -1;

                }
                else
                {
                    // oposc => usun obiekt
                    return true;
                }
            }
            return false;
        }

        public void randomMovementChange()
        {
            movement.randomChange();
        }
        public string getPosition()
        {
            return "jednostka => [" + position.X + "," + position.Y + "]";
        }

        public void changeState(State state)
        {
            this.state = state;
        }

        public double distance(Jednostka j)
        {
            return Math.Sqrt((position.X - j.position.X) * (position.X - j.position.X) + (position.Y - j.position.Y) * (position.Y - j.position.Y));
        }

        public bool equalAddr(Jednostka j) {
            if (this == j)
            {
                return true;
            }
            return false;
        }
    }
}
