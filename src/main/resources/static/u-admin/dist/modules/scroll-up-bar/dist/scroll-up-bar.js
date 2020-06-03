/* scroll-up-bar v0.3.0 (https://github.com/eduardomb/scroll-up-bar) */
(function($) {
  'use strict';

  var _destroyFn;

  $.scrollupbar = function($bar, options) {
    // Default options
    options = $.extend({
      enterViewport: $.noop,
      fullyEnterViewport: $.noop,
      exitViewport: $.noop,
      partiallyExitViewport: $.noop
    }, options);

    function isFullyInViewport() {
      return $window.scrollTop() <= $bar.offset().top;
    }

    function isInViewport() {
      return $window.scrollTop() < $bar.offset().top + $bar.outerHeight();
    }

    var $window = $(window),
        $document = $(document),
        minY = $bar.css('position') == 'fixed' ? 0 : $bar.offset().top,
        lastY = $window.scrollTop(), // Use last Y to detect scroll direction.
        initialPosTop = $bar.position().top,
        timeout;

    $.scrollupbar.isInViewport = isInViewport();
    $.scrollupbar.isFullyInViewport = isFullyInViewport();

    $window.on('scroll.scrollupbar', function() {
      var y = $window.scrollTop(),
          barHeight = $bar.outerHeight();

      // Ignore elastic scrolling.
      if (y < 0 || y > ($document.height() - $window.height())) {
        return;
      }

      // Cancel the event fired by the previous scroll.
      if (timeout) {
        clearTimeout(timeout);
      }

      if (y < lastY) { // Scrolling up
        // If the bar is hidden, place it right above the top frame.
        if (!$.scrollupbar.isInViewport && lastY - barHeight >= minY) {
          $bar.css('top', lastY - barHeight);
          $.scrollupbar.isInViewport = true;
          options.enterViewport();
        }

        // Scrolls up bigger than the bar's height fixes the bar on top.
        if (isFullyInViewport()) {
          if (y >= minY) {
            $bar.css({
              'position': 'fixed',
              'top': 0
            });
          } else {
            $bar.css({
              'position': 'absolute',
              'top': initialPosTop
            });
          }

          if (!$.scrollupbar.isFullyInViewport) {
            $.scrollupbar.isFullyInViewport = true;
            options.fullyEnterViewport();
          }
        }

        // Fire an event to reveal the entire bar after 400ms if the scroll
        // wasn't big enough.
        timeout = setTimeout(function() {
          if (!$.scrollupbar.isFullyInViewport) {
            $bar.css({
              'position': 'fixed',
              'top': $bar.offset().top - y
            });

            $bar.animate({'top': 0}, 100, function() {
              $.scrollupbar.isFullyInViewport = true;
              options.fullyEnterViewport();
            });
          }
        }, 400);
      } else if (y > lastY) { // Scrolling down
        // Unfix the bar allowing it to scroll with the page.
        if ($.scrollupbar.isFullyInViewport) {
          $bar.css({
            // translate3d fixes iOS invisible element bug when changing
            // position values while scrolling.
            'transform': 'translate3d(0, 0, 0)',
            'position': 'absolute',
            'top': lastY > minY ? lastY : initialPosTop
          });

          if (!isFullyInViewport()) {
            $.scrollupbar.isFullyInViewport = false;
            options.partiallyExitViewport();
          }
        }

        if ($.scrollupbar.isInViewport && !isInViewport()) {
          $.scrollupbar.isInViewport = false;
          options.exitViewport();
        }

        // Fire an event to hide the entire bar after 400ms if the scroll
        // wasn't big enough.
        timeout = setTimeout(function() {
          if (isInViewport() && y - barHeight >= minY) {
            $bar.animate({'top': y - barHeight}, 100, function() {
              $.scrollupbar.isInViewport = false;
              options.exitViewport();
            });
          }
        }, 400);
      }

      lastY = y;
    });

    _destroyFn = function() {
      // Unbind all listeners added by scrollupbar plugin
      $window.off('.scrollupbar');

      // Restore original bar position.
      $bar.css({
        'position': 'absolute',
        'top': initialPosTop
      });
    };

    return $bar;
  };

  $.scrollupbar.destroy = function() {
    if (_destroyFn) {
      return _destroyFn();
    }
  };

  $.fn.scrollupbar = function(options) {
    return $.scrollupbar(this, options);
  };
})(jQuery);
