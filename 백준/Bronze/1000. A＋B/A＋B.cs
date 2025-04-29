
namespace BaekjoonC_
{
    internal class BJ2851
    {
        static void Main(String[] args) {
            string? line = Console.ReadLine();
            if (line != null)
            {
                string[] input = line.Split();
                int A, B;

                A = int.Parse(input[0]);
                B = int.Parse(input[1]);

                Console.WriteLine("{0}", A + B);
                //Console.WriteLine(A + B);
            }
        }
    }
}
