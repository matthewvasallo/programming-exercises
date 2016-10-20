namespace FindFirstDuplicateNumber{
    public class Program
    {
        public static void Main(string[] args)
        {
            //Your code goes here
            int[] sampleData = new int[]{ 6, 3, 1, 4, 7, 4, 2, 8, 9 };
            Console.WriteLine(FindFirstDuplicateNumber(sampleData));
        }

        public static int FindFirstDuplicateNumber(int[] list)
        {
            HashSet<int> seenNumbers = new HashSet<int>();
            for (int i = 0; i < list.Length; i++)
            {
                if (seenNumbers.Contains(list[i]))
                {
                    return list[i];
                }
                else
                {
                    seenNumbers.Add(list[i]);
                }
            }
            return -1;
        }
    }
}