#include <iostream>
#include <vector>
#include <utility>
#include <queue>
using namespace std;

struct point
{
    int x, y;
};

struct openList
{
    int v;
    double f;
    double g;
    double h;
    int parent;
};

struct compare {
	bool operator()(const openList& s1, const openList& s2) {
		return s1.f > s2.f;
	}
};

double getDistanceFormula(point xy[], int v1, int v2)
{
    int x1 = xy[v1].x < xy[v2].x ? xy[v1].x : xy[v2].x;
    int x2 = xy[v1].x > xy[v2].x ? xy[v1].x : xy[v2].x;

    int y1 = xy[v1].y < xy[v2].y ? xy[v1].y : xy[v2].y;
    int y2 = xy[v1].y > xy[v2].y ? xy[v1].y : xy[v2].y;

    return sqrt(pow(x2-x1, 2) + pow(y2-y1, 2));
}

void addEdge(vector<pair<int, double>> v[], int v1, int v2, double w)
{
    v[v1].push_back(make_pair(v2, w));
    v[v2].push_back(make_pair(v1, w));
}

openList makeOpenList(pair<int, double> m, point xy[], int parent, int end)
{
    openList o;
    o.parent = parent;
    o.v = m.first;
    o.g = m.second;
    o.h = getDistanceFormula(xy, o.v, end);
    o.f = o.g + o.h;

    return o;
}

void Astar(vector<pair<int, double>> m[], point xy[], int start, int end)
{
    priority_queue<openList, vector<openList>, compare> pq;
    openList o;
    bool closeList[7] = {false, };
    int v = start;

    closeList[start] = true;

    while (v != end)
    {
        vector<pair<int, double>>::iterator itor = m[v].begin();

        for (; itor != m[v].end(); itor++)
        {
            pq.push(makeOpenList(*itor, xy, v, end));
        }
        
        v = pq.top().v;
        closeList[v] = true;
        pq.pop();
    }

    for (int i = 0; i < 7; i++)
        if (closeList[i])
            cout << i << " ";
    cout << endl;
}

int main()
{
    int V = 7;
    vector<pair<int, double>> map[V];
    point xy[V];

    xy[0].x = 0;
    xy[0].y = 4;

    xy[1].x = 4;
    xy[1].y = -4;

    xy[2].x = -1;
    xy[2].y = -2;

    xy[3].x = 7;
    xy[3].y = 5;

    xy[4].x = -4;
    xy[4].y = 6;
    
    xy[5].x = 10;
    xy[5].y = -5;

    xy[6].x = 15;
    xy[6].y = 4;

    addEdge(map, 0, 1, getDistanceFormula(xy, 0, 1));
    addEdge(map, 0, 3, getDistanceFormula(xy, 0, 3));
    addEdge(map, 1, 2, getDistanceFormula(xy, 1, 2));
    addEdge(map, 1, 4, getDistanceFormula(xy, 1, 4));
    addEdge(map, 2, 3, getDistanceFormula(xy, 2, 3));
    addEdge(map, 2, 5, getDistanceFormula(xy, 2, 5));
    addEdge(map, 2, 6, getDistanceFormula(xy, 2, 6));
    addEdge(map, 3, 5, getDistanceFormula(xy, 3, 5));
    addEdge(map, 4, 6, getDistanceFormula(xy, 4, 6));
    addEdge(map, 5, 6, getDistanceFormula(xy, 5, 6));

    Astar(map, xy, 0, 6);
}