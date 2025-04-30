namespace BaekjoonC_
{
    internal class BJ9085
    {
        static void Main(String[] args)
        {
            int T, N, i, j;

            T = int.Parse(Console.ReadLine());
            for(i = 0; i < T; i++)
            {
                int sum = 0;

                N = int.Parse(Console.ReadLine());
                string[] input = Console.ReadLine().Split();
                for (j = 0; j < N; j++)
                {
                    sum += int.Parse(input[j]);
                }

                Console.WriteLine(sum);
            }
        }
    }
}
