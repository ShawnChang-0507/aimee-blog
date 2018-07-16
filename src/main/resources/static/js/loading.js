function _toConsumableArray(e) {
    if (Array.isArray(e)) {
        for (var n = 0, t = Array(e.length);
            n < e.length; n++)
            t[n] = e[n];
        return t
    }
    return Array.from(e)
} !function (e) {
    "undefined" == typeof module ? this.charming = e : module.exports = e
}
    (function (e, n) {
        "use strict";
        var t = (n = n || {}).tagName || "span",
            a = null != n.classPrefix ? n.classPrefix : "char",
            r = 1;
        return function e(n) {
            for (var i = [].slice.call(n.childNodes), o = i.length, d = -1; ++d < o;)
                e(i[d]);
            n.nodeType === Node.TEXT_NODE && function (e) {
                for (var n = e.parentNode, i = e.nodeValue, o = i.length, d = -1; ++d < o;) {
                    var u = document.createElement(t);
                    a && (u.className = a + r, r++),
                        u.appendChild(document.createTextNode(i[d])),
                        n.insertBefore(u, e)
                } n.removeChild(e)
            }(n)
        }(e), e
    });
var DOM = {};
DOM.intro = document.querySelector(".content--intro"),
    DOM.shape = DOM.intro.querySelector("svg.shape"),
    DOM.path = DOM.shape.querySelector("path"),
    DOM.enter = document.querySelector(".enter"),
    charming(DOM.enter),
    DOM.enterLetters = Array.from(DOM.enter.querySelectorAll("span")),
    DOM.shape.style.transformOrigin = "50% 0%";
var init = function () {
    DOM.enter.addEventListener("click", navigate),
        DOM.enter.addEventListener("touchenter", navigate),
        DOM.enter.addEventListener("mouseenter", enterHoverInFn),
        DOM.enter.addEventListener("mouseleave", enterHoverOutFn)
};
window.loaded = !1;
var navigate = function () {
    window.loaded || (window.loaded = !0, anime({
        targets: DOM.intro,
        duration: 1100,
        easing: "easeInOutSine",
        translateY: "-200vh"
    }),
        anime({
            targets: DOM.shape,
            scaleY: [{ value: [.8, 1.8], duration: 550, easing: "easeInQuad" }, { value: 1, duration: 550, easing: "easeOutQuad" }]
        }),
        anime({
            targets: DOM.path,
            duration: 1100, easing: "easeOutQuad",
            d: DOM.path.getAttribute("pathdata:id")
        })
    )
},
    isActive = void 0,
    enterTimeout = void 0,
    enterHoverInFn = function () {
        return enterTimeout = setTimeout(function () {
            isActive = !0, anime.remove(DOM.enterLetters),
                anime({
                    targets: DOM.enterLetters,
                    delay: function (e, n) {
                        return 15 * n
                    },
                    translateY: [{ value: 10, duration: 150, easing: "easeInQuad" }, { value: [-10, 0], duration: 150, easing: "easeOutQuad" }],
                    opacity: [{ value: 0, duration: 150, easing: "linear" }, { value: 1, duration: 150, easing: "linear" }],
                    color: {
                        value: "#ff963b",
                        duration: 1,
                        delay: function (e, n, t) {
                            return 15 * n + 150
                        }
                    }
                })
        },
            50)
    },
    enterHoverOutFn = function () {
        clearTimeout(enterTimeout),
            isActive && (isActive = !1,
                anime.remove(DOM.enterLetters),
                anime({
                    targets: DOM.enterLetters,
                    delay: function (e, n, t) {
                        return 15 * (t - n - 1)
                    },
                    translateY: [{ value: 10, duration: 150, easing: "easeInQuad" }, { value: [-10, 0], duration: 150, easing: "easeOutQuad" }],
                    opacity: [{ value: 0, duration: 150, easing: "linear" }, { value: 1, duration: 150, easing: "linear" }],
                    color: { value: "#ffffff", duration: 1, delay: function (e, n, t) { return 15 * (t - n - 1) + 150 } }
                })
            )
    };
init();
var inF = !0,
    hiddenProperty = "hidden" in document ? "hidden" : "webkitHidden" in document ? "webkitHidden" : "mozHidden" in document ? "mozHidden" : null,
    visibilityChangeEvent = hiddenProperty.replace(/hidden/i, "visibilitychange"),
    wrap = document.querySelector(".wrap");
function homeLoad() {
    !document[hiddenProperty] && inF && new Promise(function (e, n) {
        e(wrap.classList.add("in"))
    }).then(function () {
        setTimeout(function () {
            $(".content__subtitle").html("<span>" + [].concat(_toConsumableArray("I will greet this day with love in my heart!")).join("</span><span>") + "</span>")
        }, 300), inF = !1
    })
}
window.addEventListener(visibilityChangeEvent, homeLoad),
    window.addEventListener("DOMContentLoaded", homeLoad),
    window.addEventListener("beforeunload", function () {
        wrap.classList.remove("in")
    });