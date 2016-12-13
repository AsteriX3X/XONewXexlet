package ua.com.asterix.xo.model.gamers;

import ua.com.asterix.xo.model.Point;

interface IShootable {
    Point getShoot();
    Point getShoot(final int x, final int y);
}
