$(function() {

	$('#msgControl').html("");
	var $form = $('#form-with-tooltip');
	var $tooltip = $('<div id="vld-tooltip">提示信息！</div>');
	$tooltip.appendTo(document.body);
	$form.validator();

	var validator = $form.data('amui.validator');
	$form.on('focusin focusout', '.am-form-error input', function(e) {
		if (e.type === 'focusin') {
			var $this = $(this);
			var offset = $this.offset();
			var msg = $this.data('foolishMsg')
					|| validator.getValidationMessage($this.data('validity'));

			$tooltip.text(msg).show().css({
				left : offset.left + 10,
				top : offset.top + $(this).outerHeight() + 10
			});
		} else {
			$tooltip.hide();
		}
	});
	/***************************************************************************
	 * pushHistory(); window.addEventListener("popstate", function(e){return
	 * false;}, false); function pushHistory(){ var state =
	 * {title:"title",url:"prdct/index"};
	 * window.history.pushState(state,"title","prdct/index"); }
	 **************************************************************************/
	
	$.AMUI.sticky.prototype.checkPosition = function() {
		if (!this.inited) {
			var initialized = this.init();
			if (!initialized) {
				return;
			}
		}

		var options = this.options;
		var scrollTop = this.$window.scrollTop();
		var offsetTop = options.top;
		var offsetBottom = options.bottom;
		var $element = this.$element;
		var animation = (options.animation) ? ' am-animation-' + options.animation : '';
		var className = [ options.className.sticky, animation ].join(' ');

		if (typeof offsetBottom == 'function') {
			offsetBottom = offsetBottom(this.$element);
		}

		var checkResult = (scrollTop > this.$holder.offset().top);

		if (!this.sticked && checkResult) {
			$element.addClass(className);
		} else if (this.sticked && !checkResult) {
			this.reset();
		}

		this.$holder.css({
			height : $element.is(':visible')
					&& $element.css('position') !== 'absolute' ? $element
					.outerHeight() : ''
		});

		if (checkResult) {
			$element.css({
				top : offsetTop,
				left : this.$holder.offset().left,
			// width: this.$holder.width()
			});
		}
		this.sticked = checkResult;
	};
});