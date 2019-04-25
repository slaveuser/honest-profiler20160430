/**
 * Copyright (c) 2015 Richard Warburton (richard.warburton@gmail.com)
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 **/
package com.insightfullogic.honest_profiler.core.profiles;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the stored data model for a flamegraph
 */
public class FlameGraph
{
    private List<FlameTrace> traces = new ArrayList<>();

    public FlameGraph()
    {
    }

    public void onNewTrace(FlameTrace trace)
    {
        traces.add(trace);
    }

    public List<FlameTrace> getTraces()
    {
        return traces;
    }

    public long totalWeight()
    {
        return traces.stream().mapToLong(FlameTrace::getWeight).sum();
    }

    public int maxTraceHeight()
    {
        return traces.stream().mapToInt(trace -> trace.getMethods().size()).max().getAsInt();
    }
}
