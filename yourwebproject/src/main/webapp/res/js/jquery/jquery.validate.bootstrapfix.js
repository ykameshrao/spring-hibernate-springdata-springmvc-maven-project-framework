$.extend($.validator.prototype, {
    showLabel:function (element, message) {
        var label = this.errorsFor(element);
        if (label.length) {
            // refresh error/success class
            label.removeClass(this.settings.validClass).addClass(this.settings.errorClass);

            // check if we have a generated label, replace the message then
            label.attr("generated") && label.html(message);
        } else {
            // create label
            label = $("<" + this.settings.errorElement + "/>")
                    .attr({"for":this.idOrName(element), generated:true})
                    .addClass(this.settings.errorClass)
                    .addClass("help-inline")
                    .html(message || "");
            if (this.settings.wrapper) {
                // make sure the element is visible, even in IE
                // actually showing the wrapped element is handled elsewhere
                label = label.hide().show().wrap("<" + this.settings.wrapper + "/>").parent();
            }
            if (!this.labelContainer.append(label).length)
                this.settings.errorPlacement
                        ? this.settings.errorPlacement(label, $(element))
                        : label.insertAfter(element);
        }
        if (!message && this.settings.success) {
            label.text("");
            typeof this.settings.success == "string"
                    ? label.addClass(this.settings.success)
                    : this.settings.success(label);
        }
        this.toShow = this.toShow.add(label);
    },

    errors:function () {
        var errorClass = this.settings.errorClass.replace(' ', '.');
        return $(this.settings.errorElement + "." + errorClass, this.errorContext);
    }
});