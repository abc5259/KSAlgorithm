namespace BSP
{
    public class Node
    {
        private Node leftNode;
        private Node rightNode;
        private Node parentNode;
        private int split;      // 길 이어줄 때 split 기준으로 한번 꺾어주기 위함
        private RectInt roomRect;
        private RectInt rect;

        private Node(RectInt rect)
        {
            this.rect = rect;
        }
    }

    public class MapGenerator
    {
        void Divide(Node node, int depth)
        {
            if (depth == maxDepth) return;

            int maxLength = Mathf.Max(node.rect.x, node.rect.y);
            int randLength = Random.Range(maxLength * minRatio, maxLength * maxRatio);

            if (node.rect.x >= node.rect.y)
            {
                node.leftNode.rect = new RectInt(node.rect.x, node.rect.y, randLength, node.rect.height);
                node.rightNode.rect = new RectInt(node.rect.x + randLength, node.rect.y, maxLength - randLength, node.rect.height);
            } else 
            {
                node.leftNode.rect = new RectInt(node.rect.x, node.rect.y, node.rect.width, randLength);
                node.rightNode.rect = new RectInt(node.rect.x, node.rect.y + randLength, node.rect.width, node.rect.height - randLength);
            }

            node.leftNode.split = node.rightNode.split = randLength;
            Divide(node.leftNode, depth + 1);
            Divide(node.rightNode, depth + 1);
        }

        RectInt GenerateRoom(Node node, int depth)
        {
            if (n == maxDepth) 
            {
                int width = Random.Range(node.rect.width * 0.3, node.rect.width * 0.8);
                int height = Random.Range(node.rect.height * 0.3, node.rect.height * 0.8);
                int x = Random.Range(0, node.rect.width - width);
                int y = Random.Range(0, node.rect.height - height);
            } else
            {
                node.leftNode.roomRect = GenerateRoom(node.leftNode, depth + 1);
                node.rightNode.roomRect = GenerateRoom(node.rightNode, depth + 1);
            }

            return new Rect(x, y, width, height);
        }
    }
}