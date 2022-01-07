var n = [ 0, 0, 5, 0, 0, 4, 0, 0, 2, 0, 6, 0, 0, 5, 0, 0, 2, 0, 7, 0, 0, 5, 0, 0, 4, 0, 0, 2, 0, 6, 0, 0, 5, 0, 0, 3, 0, 7, 0, 0, 6, 0, 0, 4, 0, 0, 2, 0, 7, 0, 0, 5, 0, 0, 3, 0, 8, 0, 0, 6, 0, 0, 4, 0, 0, 3, 0, 7, 0, 0, 5, 0, 0, 4, 0, 8, 0, 0, 6, 0, 0, 4, 0, 10, 0, 0, 6, 0, 0, 5, 0, 0, 3, 0, 8, 0, 0, 5, 0, 0, 4, 0, 0, 2, 0, 7, 0, 0, 5, 0, 0, 4, 0, 9, 0, 0, 6, 0, 0, 4, 0, 0, 2, 0, 6, 0, 0, 5, 0, 0, 3, 0, 11, 0, 0, 6, 0, 0, 5, 0, 0, 2, 0, 7, 0, 0, 5, 0, 0, 3 ], t = [ 1874, 3749, 5706, 1611, 2715, 5462, 1386, 2905, 5970, 1874, 6949, 2853, 2635, 5291, 685, 1387, 2921, 3497, 7570, 3730, 3365, 6733, 2646, 694, 5557, 1748, 3753, 7826, 3730, 3366, 1323, 2647, 4790, 2906, 1748, 3785, 1865, 5779, 2707, 1323, 2651, 2733, 1386, 6997, 2980, 2889, 6803, 2709, 5421, 1334, 2733, 5546, 1458, 3493, 7498, 3402, 2709, 2711, 1366, 2741, 2773, 1746, 3749, 3749, 1610, 3223, 2715, 5466, 1386, 2921, 5970, 2898, 2853, 5707, 2635, 5291, 685, 1389, 2921, 3497, 3474, 7461, 3365, 6733, 2646, 694, 1461, 1749, 3753, 7826, 3730, 3366, 2646, 2647, 5334, 858, 1749, 5833, 1865, 1683, 5419, 1323, 2651, 5466, 1386, 6997, 2980, 2889, 6803, 2709, 1325, 2733, 2741, 5546, 1490, 3493, 7498, 3402, 3221, 5422, 1366, 2741, 5554, 1746, 3749, 1829, 1611, 3223, 3243, 1370, 2774, 2921, 5970, 2898, 2853, 6731, 2635, 1195, 1371, 1453, 2922, 6994, 3474, 7461, 3365, 2645, 5293, 1206, 1461, 3498 ], a = [ "正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "腊月" ], e = [ "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十" ], r = [ "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸" ], u = [ "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥" ], o = {
    createSolarYears: function() {
        for (var n = [], t = 1902; t <= 2049; t++) n.push({
            id: t,
            name: t + "年"
        });
        return n;
    },
    createSolarMonths: function() {
        for (var n = [], t = 1; t <= 12; t++) n.push({
            id: t,
            name: t + "月"
        });
        return n;
    },
    createSolarDays: function(n, t) {
        0 == n && (n = 2e3);
        for (var a = [], e = this.getSolarMonthDays(n, t), r = 1; r <= e; r++) a.push({
            id: r,
            name: r + "日"
        });
        return a;
    },
    getSolarMonthDays: function(n, t) {
        return 2 === t ? 3 & n || !(n % 25) && 15 & n ? 28 : 29 : 30 + (t + (t >> 3) & 1);
    },
    createLunarYears: function() {
        for (var n = [], t = 1902; t <= 2049; t++) {
            var a = t + "(" + this.getKanChiName(t) + "年)";
            n.push({
                id: t,
                name: a
            });
        }
        return n;
    },
    getKanChiName: function(n) {
        var t = (n - 1901 + 37) % 60;
        return r[t % 10] + u[t % 12];
    },
    createLunarMonths: function() {
        var n = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : 0, t = [];
        if (0 == n) for (u = 1; u <= 12; u++) t.push({
            id: u,
            name: a[u - 1]
        }); else {
            var e = this.getLunarLeapMonth(n), r = 12;
            0 != e && (r = 13);
            for (var u = 0; u < r; u++) 0 != e ? u < e ? t.push({
                id: u + 1,
                name: this.getLunarMonthName(u + 1)
            }) : u == e ? t.push({
                id: -1 * u,
                name: this.getLunarMonthName(-1 * e)
            }) : u > e && t.push({
                id: u,
                name: this.getLunarMonthName(u)
            }) : t.push({
                id: u + 1,
                name: this.getLunarMonthName(u + 1)
            });
        }
        return t;
    },
    getLunarMonthName: function(n) {
        return n < -12 || 0 === n || n > 12 ? "未知" : n < 0 ? "闰" + a[Math.abs(n) - 1] : a[Math.abs(n) - 1];
    },
    getLunarLeapMonth: function(t) {
        var a = t - 1901;
        return a >= n && (a = 0), n[a];
    },
    createLunarDays: function(n, t) {
        if (0 == n) e = 30; else var a = this.getFakeMonth(n, t), e = this.getFakeLunarMonthDays(n, a);
        for (var r = [], u = 1; u <= e; u++) r.push({
            id: u,
            name: this.getLunarDayName(u)
        });
        return r;
    },
    getFakeMonth: function(n, t) {
        var a = this.getLunarLeapMonth(n), e = t;
        return 0 != a && (t > a ? e++ : a == -1 * t && (e = a + 1)), e;
    },
    getFakeLunarMonthDays: function(n, a) {
        return 0 != (t[n - 1901] & 1 << a - 1) ? 30 : 29;
    },
    getLunarDayName: function(n) {
        return e[n - 1];
    },
    getBase: function() {
        return 1901;
    }
};

module.exports = {
    calendar: o
};